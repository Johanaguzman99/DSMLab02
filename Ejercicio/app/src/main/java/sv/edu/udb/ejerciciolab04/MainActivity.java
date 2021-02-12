package sv.edu.udb.ejerciciolab04;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.content.Intent;
public class MainActivity extends AppCompatActivity {

    private  EditText txtNombre, txtNota1, txtNota2, txtNota3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtNombre = (EditText) findViewById(R.id.txtNombre);
        txtNota1 = (EditText) findViewById(R.id.txtNota1);
        txtNota2 = (EditText) findViewById(R.id.txtNota2);
        txtNota3 = (EditText) findViewById(R.id.txtNota3);
    }

    public void calcularPromedio(View view){
        Intent i = new Intent(this, muestraResultados.class);

        i.putExtra("txtNombre", String.valueOf(txtNombre.getText()));
        i.putExtra("txtNota1", Double.parseDouble(String.valueOf(txtNota1.getText())));
        i.putExtra("txtNota2", Double.parseDouble(String.valueOf(txtNota2.getText())));
        i.putExtra("txtNota3", Double.parseDouble(String.valueOf(txtNota3.getText())));
        startActivity(i);
    }
}