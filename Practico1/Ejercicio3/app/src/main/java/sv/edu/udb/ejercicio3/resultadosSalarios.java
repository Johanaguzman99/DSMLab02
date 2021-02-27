package sv.edu.udb.ejercicio3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.widget.TextView;
import android.widget.Toast;
public class resultadosSalarios extends AppCompatActivity {

    private TextView txtvResultado1, txtvResultado2, txtvResultado3, txtvResultado4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados_salarios);
        txtvResultado1 = (TextView)findViewById(R.id.txtvResultado1);
        txtvResultado2 = (TextView)findViewById(R.id.txtvResultado2);
        txtvResultado3 = (TextView)findViewById(R.id.txtvResultado3);
        txtvResultado4 = (TextView)findViewById(R.id.txtvResultado4);
        presentarResultados();

    }

    public void presentarResultados() {
        Bundle bundle = getIntent().getExtras();
        String[] nombres = bundle.getStringArray("nombresEmpleados");
        String[] apellidos = bundle.getStringArray("apellidosEmpleados");
        String[] cargos = bundle.getStringArray("cargosEmpleados");
        int[] horas = bundle.getIntArray("horasEmpleados");
        String condicion = cargos[0]+"-"+cargos[1]+"-"+cargos[2];
        String[] mensajes = {"","",""};
        String[] estadisticas = {"", ""};
        int contador = 0;
        double menorGana= horas[0] * 9.75, mayorGana=0;

        for(int i=0; i< 3; i++){
            mensajes[i] ="";
            double pagoHoras = 0;
            double bono = 0;
            mensajes[i]+= "Nombre Completo : "+nombres[i]+" "+apellidos[i];
            if(horas[i] >160 ){
                int horasExtras = (horas[i] - 160);
                float pagoHN = 160*9.75f;
                float pagoHE= horasExtras*11.50f;
                pagoHoras = pagoHN + pagoHE;
                mensajes[i] += "\n Pago todat horas : $"+String.valueOf(pagoHoras);
            }else{
                pagoHoras = horas[i] * 9.75;
                mensajes[i] += "\nPago total horas : $"+String.valueOf(pagoHoras);
            }
            double ISSS =  Math.round((pagoHoras*0.0525)*100.0)/100.0;
            double AFP = Math.round((pagoHoras*0.0688f)*100.0)/100.0;
            double Renta = Math.round((pagoHoras*0.10f)*100.0)/100.0;
            double totalDescuento = ISSS + AFP + Renta;
            double salarioLiquido = (pagoHoras-totalDescuento);
            mensajes[i]+="\nDescuento ISS : $"+String.valueOf(ISSS)+"\nDescuento AFP : $"+String.valueOf(AFP)+"\nDescuento Renta : $"+String.valueOf(Renta)+"\nSalario liquido : $"+String.valueOf(salarioLiquido);

            if(condicion.equals("gerente-asistente-secretaria")){
                bono = 0;

            }else{
                switch (cargos[i]){
                    case "gerente" :
                        bono = salarioLiquido*0.10;
                        break;
                    case "asistente":
                        bono = salarioLiquido* 0.05;
                        break;
                    default:
                        bono = salarioLiquido*0.03;
                }

                mensajes[i]+= "\nSalario con bono : $"+String.valueOf(Math.round((salarioLiquido+bono)*100.0)/100.0);

            }

            if(menorGana >= pagoHoras){
                menorGana = pagoHoras;
                estadisticas[0] = nombres[i];
            }
            if(mayorGana <= pagoHoras){
                mayorGana = pagoHoras;
                estadisticas[1] = nombres[i];
            }
            if(pagoHoras>300) contador++;
        }
        if(condicion.equals("gerente-asistente-secretaria"))Toast.makeText(this,"No habra bono por secuencia!" ,Toast.LENGTH_LONG).show();
        txtvResultado1.setText(mensajes[0].toString());
        txtvResultado2.setText(mensajes[1].toString());
        txtvResultado3.setText(mensajes[2].toString());
        txtvResultado4.setText("Empleado mayor salarrio : "+estadisticas[1]+"\nEmpleado menor salario : "+estadisticas[0]+"\n Empleados con salario > $300 : "+contador);
    }
}