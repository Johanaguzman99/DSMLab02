package edu.udb.sqliteapp;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText et1,et2,et3,et4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1=(EditText)findViewById(R.id.et1);
        et2=(EditText)findViewById(R.id.et2);
        et3=(EditText)findViewById(R.id.et3);
        et4= findViewById(R.id.et4);

    }

    public void alta(View v) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"administracion", null, 1);

        SQLiteDatabase bd = admin.getWritableDatabase();

        String nombre = et1.getText().toString();
        String apellido = et2.getText().toString();
        String edad = et3.getText().toString();
        String tel= et4.getText().toString();

        ContentValues registro = new ContentValues();

        registro.put("nombre", nombre);
        registro.put("ape", apellido);
        registro.put("edad", edad);
        registro.put("telefono",tel);

        try {
            bd.insertOrThrow("persona", null, registro);
            bd.close();
            et1.setText("");
            et2.setText("");
            et3.setText("");
            et4.setText("");

            Toast.makeText(this, "Dato agregado correctamente",Toast.LENGTH_SHORT).show();
        } catch (SQLiteException e) {
            Toast.makeText(this, "ERROR. No se pudieron almacenar los datos " + e.getMessage(),Toast.LENGTH_SHORT).show();
        }

    }

    public void consultapornombre(View v) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"administracion", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String name = et1.getText().toString();
        Cursor fila = bd.rawQuery("select ape, edad, telefono from persona where nombre=" + name, null);
        if (fila.moveToFirst()) {
            et2.setText(fila.getString(0));
            et3.setText(fila.getString(1));
            et4.setText(fila.getString(2));
        } else
            Toast.makeText(this, "Registro no existente",
                    Toast.LENGTH_SHORT).show();
        bd.close();
    }



    public void bajapornombre(View v) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"administracion", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String name= et1.getText().toString();
        int cant = bd.delete("persona", "nombre=" + name, null);
        bd.close();
        et1.setText("");
        et2.setText("");
        et3.setText("");
        et4.setText("");
        if (cant == 1)
            Toast.makeText(this, "Se borró ese registro",
                    Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "No existe ese registro",
                    Toast.LENGTH_SHORT).show();
    }

    public void modificacion(View v) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"administracion", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String nombre = et1.getText().toString();
        String apellido = et2.getText().toString();
        String edad = et3.getText().toString();
        String telefono= et4.getText().toString();

        ContentValues registro = new ContentValues();
        registro.put("nombre", nombre);
        registro.put("ape", apellido);
        registro.put("edad", edad);
        registro.put("telefono", telefono);
        int cant = bd.update("persona", registro, "nombre=" + nombre, null);
        bd.close();
        if (cant == 1)
            Toast.makeText(this, "se modificaron los datos", Toast.LENGTH_SHORT)
                    .show();
        else
            Toast.makeText(this, "no existe ese registro",
                    Toast.LENGTH_SHORT).show();
    }
}
