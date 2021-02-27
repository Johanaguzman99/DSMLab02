package sv.edu.udb.ejercicio3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.view.View;
import android.content.Intent;
import android.widget.Toast;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private EditText txtNombre1, txtApellidos1, txtCargo1, txtHorasSalario1,
                     txtNombre2, txtApellidos2, txtCargo2, txtHorasSalario2,
                     txtNombre3, txtApellidos3, txtCargo3, txtHorasSalario3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Datos empleado 1
        txtNombre1 = (EditText)findViewById(R.id.txtnombre1);
        txtApellidos1= (EditText)findViewById(R.id.txtapellidos1);
        txtCargo1 = (EditText)findViewById(R.id.txtcargo1);
        txtHorasSalario1 = (EditText)findViewById(R.id.txthorasMes1);
        //Datos empleado 2
        txtNombre2 = (EditText)findViewById(R.id.txtnombre2);
        txtApellidos2= (EditText)findViewById(R.id.txtapellidos2);
        txtCargo2 = (EditText)findViewById(R.id.txtcargo2);
        txtHorasSalario2 = (EditText)findViewById(R.id.txthorasMes2);
        //Datos empleado 3
        txtNombre3 = (EditText)findViewById(R.id.txtnombre3);
        txtApellidos3= (EditText)findViewById(R.id.txtapellidos3);
        txtCargo3 = (EditText)findViewById(R.id.txtcargo3);
        txtHorasSalario3 = (EditText)findViewById(R.id.txthorasMes3);
    }

    public void pasarDatosValidos(View view){
        String nombres1 = txtNombre1.getText().toString();
        String apellidos1 = txtApellidos1.getText().toString();
        String Cargo1 = txtCargo1.getText().toString().replace(" ","").toLowerCase();
        int horasMes1 = Integer.parseInt(txtHorasSalario1.getText().toString());

        String nombres2 = txtNombre2.getText().toString();
        String apellidos2 = txtApellidos2.getText().toString();
        String Cargo2 = txtCargo2.getText().toString().replace(" ","").toLowerCase();
        int horasMes2 = Integer.parseInt(txtHorasSalario2.getText().toString());

        String nombres3 = txtNombre3.getText().toString();
        String apellidos3 = txtApellidos3.getText().toString();
        String Cargo3 = txtCargo3.getText().toString().replace(" ","").toLowerCase();
        int horasMes3 = Integer.parseInt(txtHorasSalario3.getText().toString());

        Intent i = new Intent(this,resultadosSalarios.class);

        String[] cargosEmpleados = {"gerente", "asistente", "secretaria"};

        if(nombres1.isEmpty() || apellidos1.isEmpty() || Cargo1.isEmpty() || String.valueOf(horasMes1).length() < 1 ) Toast.makeText(this,"Datos del primer empleado incompletos!",Toast.LENGTH_LONG).show();
        else if(nombres2.isEmpty() || apellidos2.isEmpty() || Cargo2.isEmpty() || String.valueOf(horasMes2).length() < 1 ) Toast.makeText(this,"Datos del segundo empleado incompletos!",Toast.LENGTH_LONG).show();
        else if(nombres3.isEmpty() || apellidos3.isEmpty() || Cargo3.isEmpty() || String.valueOf(horasMes3).length() < 1 ) Toast.makeText(this,"Datos del segundo empleado incompletos!",Toast.LENGTH_LONG).show();

        else{
            if(horasMes1 < 1) Toast.makeText(this,"Horas del primer empleado invalidas!",Toast.LENGTH_LONG).show();
            else if(horasMes2 < 1) Toast.makeText(this,"Horas del segundo empleado invalidas!",Toast.LENGTH_LONG).show();
            else if(horasMes3 < 1) Toast.makeText(this,"Horas del tercer empleado invalidas!",Toast.LENGTH_LONG).show();
            else if(Arrays.asList(cargosEmpleados).contains(String.valueOf(Cargo1).toLowerCase()) && Arrays.asList(cargosEmpleados).contains(String.valueOf(Cargo2.toLowerCase())) && Arrays.asList(cargosEmpleados).contains(String.valueOf(Cargo3.toLowerCase())) ){
                String[] nombres = {nombres1, nombres2, nombres3};
                String[] apellidos = {apellidos1, apellidos2, apellidos3};
                String[] cargos = {Cargo1, Cargo2, Cargo3};
                int[] horasMes = {horasMes1, horasMes2, horasMes3};

                i.putExtra("nombresEmpleados", nombres);
                i.putExtra("apellidosEmpleados", apellidos);
                i.putExtra("cargosEmpleados", cargos);
                i.putExtra("horasEmpleados", horasMes);

                startActivity(i);
            }

            else Toast.makeText(this,"Dato invalido en cargo empleado(Valores aceptados: gerente, asistente, secretaria)" ,Toast.LENGTH_LONG).show();
        }
    }
}