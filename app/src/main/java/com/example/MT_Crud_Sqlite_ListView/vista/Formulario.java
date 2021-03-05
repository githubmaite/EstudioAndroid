package com.example.MT_Crud_Sqlite_ListView.vista;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.MT_Crud_Sqlite_ListView.R;
import com.example.MT_Crud_Sqlite_ListView.modelo.AdminSQLiteOpenHelper;

public class Formulario extends AppCompatActivity {

    //static final int id=0;
    //edtxFecNac
    EditText etx_correo, etx_nombre, etx_pais,etx_telefono,etx_comentario;
    EditText etx_id, etx_fecnac;
    String id,correo,nombre,telefono,fecnac,pais,comentario;
    int telefono_n, fecnac_n;
    int id_n;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

            etx_id=findViewById(R.id.edtxid);
            etx_correo=findViewById(R.id.edtxcorreo);
            etx_nombre=findViewById(R.id.edtxnombre);
            etx_telefono=findViewById(R.id.edtxtelefono);
            etx_fecnac=findViewById(R.id.edtxFecNac);
            etx_pais=findViewById(R.id.edtxpais);
            etx_comentario=findViewById(R.id.edtxcomentario);

    }

    public void guardar(View v){


          AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
          // abrir en modo lectura y escritura
          SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

           //numpassw= Integer.parseInt(password);
          id = etx_id.getText().toString();
          id_n = Integer.parseInt(id);

          correo = etx_correo.getText().toString();
          nombre = etx_nombre.getText().toString();

          telefono = etx_telefono.getText().toString();
          telefono_n = Integer.parseInt(telefono);

          fecnac = etx_fecnac.getText().toString();
          fecnac_n = Integer.parseInt(telefono);

          pais = etx_pais.getText().toString();
          comentario = etx_comentario.getText().toString();

          if (!id.isEmpty() && !correo.isEmpty() && !nombre.isEmpty()  && !telefono.isEmpty()
                  && !pais.isEmpty()  && !comentario.isEmpty() ) {

              ContentValues registro = new ContentValues();

              registro.put("id", id_n);
              registro.put("correo", correo);
              registro.put("nombre", nombre);
              registro.put("telefono",telefono);
              //registro.put("fecnac",fecnac);
              registro.put("pais",pais);
              registro.put("comentario",comentario);

                BaseDeDatos.insert("persona", null, registro);

              BaseDeDatos.close();

              etx_id.setText("");
              etx_correo.setText("");
              etx_nombre.setText("");
              etx_telefono.setText("");
              etx_fecnac.setText("");
              etx_pais.setText("");
              etx_comentario.setText("");

              Toast.makeText(this, "Registro exitoso", Toast.LENGTH_LONG).show();
          } else {
              Toast.makeText(this, "Llenar todos los campos", Toast.LENGTH_LONG).show();
          }

    }

    public void volver(View view) {
        finish();
    }
}