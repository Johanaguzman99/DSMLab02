package com.example.contadordevotos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText secuencia;
    Button contar;
    TextView prueba,vt1,vt2,vt3,vt4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        secuencia= findViewById(R.id.txtTexto);
        contar =findViewById(R.id.btnContar);
        vt1= findViewById(R.id.txtc1);
        vt2= findViewById(R.id.txtc2);
        vt3= findViewById(R.id.txtc3);
        vt4= findViewById(R.id.txtc4);





        contar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String votos= secuencia.getText().toString();
                String [] partes= votos.split("\\,");
                int tamano= partes.length;
                int[] votosint= new int[tamano];
                for (int i=0;i<tamano; i++) {
                    votosint[i]=Integer.parseInt(partes[i]);
                }

                //Del 1-4 se identifican los candidatos
                int [] identificadores = new int[5];
                for(int i=0;i<votosint.length;i++)
                {
                    identificadores[votosint[i]]+=1;
                }

                /*int cantidad = partes.length;
                    prueba.setText(partes[2]);*/
                //PORCENTAJES OBTENIDOS
                //Cantidato 1
                int porcentaje1= (100*identificadores[1])/votosint.length;
                //Cantidato 2
                int porcentaje2= (100*identificadores[2])/votosint.length;
                //Cantidato 3
                int porcentaje3= (100*identificadores[3])/votosint.length;
                //Cantidato 4
                int porcentaje4= (100*identificadores[4])/votosint.length;

                vt1.setText( "Candidato N°: "+1+""+" Votos: "+identificadores[1]+" Porcentaje:"+porcentaje1+"%");
                vt2.setText( "Candidato N°: "+2+""+" Votos: "+identificadores[2]+" Porcentaje:"+porcentaje2+"%");
                vt3.setText( "Candidato N°: "+3+""+" Votos: "+identificadores[3]+" Porcentaje:"+porcentaje3+"%");
                vt4.setText( "Candidato N°: "+4+""+" Votos: "+identificadores[4]+" Porcentaje:"+porcentaje4+"%");

                Log.d("repeticiones", "Numero"+1+":"+identificadores[1]+"veces"+" porcentajes"+porcentaje1);

                /*(int j=0;j<identificadores.length;j++)
                {

                }*/



                }








        });



    }
}