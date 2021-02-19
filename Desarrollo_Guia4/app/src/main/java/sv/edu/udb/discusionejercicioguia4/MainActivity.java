package sv.edu.udb.discusionejercicioguia4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.view.View;
import android.content.Intent;
public class MainActivity extends AppCompatActivity {

    private EditText txtNombre, txtHoras;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtNombre = (EditText) findViewById(R.id.txtNombre);
        txtHoras = (EditText)findViewById(R.id.txtHoras);
    }

    public void pasarDatos(View view){
        Intent i = new Intent(this, presentacionDeduccion.class);

        i.putExtra("nombreEmpleado",String.valueOf(txtNombre.getText()));
        i.putExtra("horasTrabajadas", Integer.parseInt(String.valueOf(txtHoras.getText())));
        startActivity(i);
    }
}