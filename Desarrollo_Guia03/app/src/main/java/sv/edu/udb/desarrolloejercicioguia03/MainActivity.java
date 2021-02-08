package sv.edu.udb.desarrolloejercicioguia03;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView txtContador;
    int contador =0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtContador = (TextView)findViewById(R.id.txtvContador);
        txtContador.setText(String.valueOf(contador));
        //Es para ver si al girar el celular este tenia valores guardados
        if(savedInstanceState != null){
           contador = savedInstanceState.getInt("contador2");
            txtContador.setText(String.valueOf(contador));
        }
    }

    public void sumarContador(View view){
        if(contador >= 9){
            contador =0;
            txtContador.setText(String.valueOf(contador));
            Toast.makeText(getApplicationContext(),
                    "Valor maximo alcanzado. Reiniciando valor.", Toast.LENGTH_SHORT).show();
        }else{
            contador++;
            txtContador.setText(String.valueOf(contador));
        }
    }

    //al cambiar orienttacion guardar datos
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("contador2",contador);
    }


}