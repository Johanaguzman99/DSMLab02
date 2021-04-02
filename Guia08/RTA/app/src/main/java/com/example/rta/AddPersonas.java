package com.example.rta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AddPersonas extends AppCompatActivity {
    EditText edtDUI, edtNombre,edtAltura,edtPeso,edtSexo,edtFecha;
    String key="",nombre="",dui="",accion="",altura="",peso="",fecha="",sexo="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_personas);

        inicializar();
    }

    private void inicializar() {
        edtNombre = findViewById(R.id.edtNombre);
        edtDUI = findViewById(R.id.edtDUI);
        edtAltura=findViewById(R.id.edtAltura);
        edtPeso=findViewById(R.id.edtPeso);
        edtSexo=findViewById(R.id.edtSexo);
        edtFecha=findViewById(R.id.edtFecha);

        // Obtención de datos que envia actividad anterior
        Bundle datos = getIntent().getExtras();
        key = datos.getString("key");
        dui = datos.getString("dui");
        nombre=datos.getString("nombre");
        peso=datos.getString("peso");
        altura=datos.getString("altura");
        fecha=datos.getString("fecha");
        sexo=datos.getString("sexo");
        accion=datos.getString("accion");
        edtDUI.setText(dui);
        edtNombre.setText(nombre);
        edtPeso.setText(peso);
        edtAltura.setText(altura);
        edtSexo.setText(sexo);
        edtFecha.setText(fecha);
    }

    public void guardar(View v){
        String nombre = edtNombre.getText().toString();
        String dui = edtDUI.getText().toString();
        String peso= edtPeso.getText().toString();
        String altura= edtAltura.getText().toString();
        String fecha= edtFecha.getText().toString();
        String sexo= edtSexo.getText().toString();
        // Se forma objeto persona
        Persona persona = new Persona(dui,nombre,peso,altura,fecha,sexo);

        if (accion.equals("a")) { //Agregar usando push()
            Personas.refPersonas.push().setValue(persona);
        }
        else // Editar usando setValue
        {
            Personas.refPersonas.child(key).setValue(persona);
        }
        finish();
    }
    public void cancelar(View v){
        finish();
    }


}