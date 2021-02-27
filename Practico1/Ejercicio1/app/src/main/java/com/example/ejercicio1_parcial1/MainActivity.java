package com.example.ejercicio1_parcial1;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText txtA, txtB, txtC;
    private TextView resultadox1, resultadox2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtA = (EditText) findViewById(R.id.txtA);
        txtB = (EditText) findViewById(R.id.txtB);
        txtC = (EditText) findViewById(R.id.txtC);
        resultadox1 = (TextView) findViewById(R.id.txtvResultadox1);
        resultadox2 = (TextView) findViewById(R.id.txtvResultadox2);
    }

    public void calcular(View view)
    {
        String n1 = txtA.getText().toString();
        String n2 = txtB.getText().toString();
        String n3 = txtC.getText().toString();

        String mensaje ="";

        if(n1=="" | n2=="" | n3=="")
        {
            mensaje = "¡Hay campos vacios!";
            resultadox1.setText(" Ha ocurrido un error");
            resultadox2.setText(mensaje);
        }
        else {
            double a = Double.parseDouble(n1);
            double b = Double.parseDouble(n2);
            double c = Double.parseDouble(n3);


            if (a != 0) {

                double bc = Math.pow(b, 2);
                double r = Math.sqrt(bc - (4 * a * c));
                if (r >= 0) {
                    double x1 = ((-b) + (r)) / (2 * a);
                    double x2 = ((-b) - (r)) / (2 * a);

                    String resultado1 = "X1 = " + String.valueOf(x1);
                    String resultado2 = "X2 = " + String.valueOf(x2);

                    resultadox1.setText(resultado1);
                    resultadox2.setText(resultado2);
                } else {

                    mensaje = "¡La raíz da número negativo!";
                    resultadox1.setText(" ");
                    resultadox2.setText(mensaje);

                }

            }//a diferente de 0
            else {
                mensaje = "¡División entre 0!";
                resultadox1.setText(" ");
                resultadox2.setText(mensaje);
            }

          }//fin else vacio
        }//fin metodo

}