package sv.edu.udb.sumamvp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SumaView extends AppCompatActivity implements Suma.View{

    TextView txtvresultado;
    EditText txtNum1, txtNum2;
    private Suma.Presenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtNum1 = findViewById(R.id.txtNum1);
        txtNum2 = findViewById(R.id.txtNum2);
        txtvresultado = findViewById(R.id.txtResultado);
        presenter = new SumaPresenter(this);
    }

    //Aqui ponemos los numeros en un Arreglo
    public void ProcesarNumeros(View view){
        String datos[];
        datos = new String[2];
        datos[0] = txtNum1.getText().toString();
        datos[1] = txtNum2.getText().toString();
        presenter.sumar(datos);
    }

    @Override
    public void mostrarResultado(String resultado) {
        txtvresultado.setText(resultado);
    }

    @Override
    public void mostrarErrores(String error) {
        txtvresultado.setText(error);
    }
}