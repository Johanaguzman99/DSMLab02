package sv.edu.udb.discusionejercicioguia4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.widget.EditText;
import android.widget.TextView;

public class presentacionDeduccion extends AppCompatActivity {

    private TextView txtvNombre, txtvISSS, txtvAFP, txtvRenta, txtvSalarioBruto, txtvSalarioNeto, txtvTotalDescuento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_presentacion_deduccion);
        txtvNombre = (TextView)findViewById(R.id.txtvNombre);
        txtvISSS = (TextView)findViewById(R.id.txtvISSS);
        txtvAFP = (TextView)findViewById(R.id.txtvAFP);
        txtvRenta = (TextView) findViewById(R.id.txtvRenta);
        txtvSalarioBruto = (TextView)findViewById(R.id.txtvSalarioBruto);
        txtvSalarioNeto = (TextView)findViewById(R.id.txtvSalarioNeto);
        txtvTotalDescuento = (TextView)findViewById(R.id.txtvTotalDescuento);
        calcularDeducciones();
    }

    public void calcularDeducciones(){
        Bundle bundle = getIntent().getExtras();
        int horas = bundle.getInt("horasTrabajadas");
        String empleado = bundle.getString("nombreEmpleado");
        double precioHoras = 8.50;
        double salarioBruto = horas * precioHoras;
        double ISS = salarioBruto* 0.02;
        double AFP = salarioBruto* 0.03;
        double Renta = salarioBruto*0.04;
        double totalDescuento = ISS+AFP+Renta;
        double salarioNeto = salarioBruto-totalDescuento;

        txtvNombre.setText("Empleado : "+empleado);
        txtvISSS.setText("ISS : $"+String.valueOf(ISS));
        txtvAFP.setText("AFP : $"+String.valueOf(AFP));
        txtvRenta.setText("Renta : $"+String.valueOf(Renta));
        txtvSalarioBruto.setText("Salario : $"+String.valueOf(salarioBruto));
        txtvTotalDescuento.setText("Descuento : $"+String.valueOf(totalDescuento));
        txtvSalarioNeto.setText("Salario Neto : $"+String.valueOf(salarioNeto));
    }
}