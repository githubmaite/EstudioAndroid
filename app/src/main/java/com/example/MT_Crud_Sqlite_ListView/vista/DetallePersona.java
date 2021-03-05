package com.example.MT_Crud_Sqlite_ListView.vista;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

import com.example.MT_Crud_Sqlite_ListView.R;
import com.example.MT_Crud_Sqlite_ListView.modelo.Persona;

public class DetallePersona extends AppCompatActivity {

    //static final int id=0;
    //edtxFecNac
    EditText etx_correo, etx_nombre, etx_pais, etx_telefono, etx_comentario;
    EditText etx_id, etx_fecnac;
    String id, correo, nombre, telefono, fecnac, pais, comentario;
    int telefono_n, fecnac_n;
    int id_n;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_persona);

        etx_id = findViewById(R.id.edtxid);
        etx_correo = findViewById(R.id.edtxcorreo);
        etx_nombre = findViewById(R.id.edtxnombre);
        etx_telefono = findViewById(R.id.edtxtelefono);
        //etx_fecnac = findViewById(R.id.edtxFecNac);
        etx_pais = findViewById(R.id.edtxpais);
        etx_comentario = findViewById(R.id.edtxcomentario);

        Bundle objetoEnviado = getIntent().getExtras();
        Persona pers = null;
        if (objetoEnviado != null) {

            pers = (Persona) objetoEnviado.getSerializable("persona");
            int id= pers.getId();
            etx_id.setText(String.valueOf(id));

            etx_correo.setText(pers.getCorreo().toString());
            etx_nombre.setText(pers.getNombre().toString());
            etx_telefono.setText(pers.getTelefono().toString());
            //etx_fecnac = findViewById(R.id.edtxFecNac);
            etx_pais.setText(pers.getPais().toString());
            etx_comentario.setText(pers.getComentarios().toString());

        }
    }
}