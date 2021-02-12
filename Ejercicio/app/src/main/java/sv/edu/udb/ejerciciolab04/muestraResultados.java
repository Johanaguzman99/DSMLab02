package sv.edu.udb.ejerciciolab04;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;

public class muestraResultados extends AppCompatActivity {

    private TextView txtvNombre, txtvNotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_muestra_resultados);

        txtvNombre = (TextView) findViewById(R.id.txtvEstudiante);
        txtvNotas = (TextView) findViewById(R.id.txtvResultado);

        promedio();
    }

    public void promedio(){
        Bundle bundle = getIntent().getExtras();
        String  nombre = bundle.getString("txtNombre");
        Double nota1 = bundle.getDouble("txtNota1");
        Double nota2 = bundle.getDouble("txtNota2");
        Double nota3 = bundle.getDouble("txtNota3");
        Double prom = (nota1+nota2+nota3)/3;
        String mensaje ="";

        txtvNombre.setText("Estudiante : "+ nombre);
        mensaje = "     Nota1 ="+String.valueOf(nota1)+"\n\n" + "       Nota2 ="+String.valueOf(nota2)+"\n\n" +"        Nota3 ="+String.valueOf(nota3)+"\n\n\n";
        if(prom <= 5) mensaje+="Estudiante reprobado";
        else if(prom >5 && prom <7) mensaje+= "Estudiante Regular";
        else if(prom>7 && prom<=10) mensaje+= "Estudiante Excelente";
        else{
            mensaje="Ocurrio un Error!";
        }

        txtvNotas.setText(mensaje);
    }
}