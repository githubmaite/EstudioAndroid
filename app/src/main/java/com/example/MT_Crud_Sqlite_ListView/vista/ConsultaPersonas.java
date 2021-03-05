package com.example.MT_Crud_Sqlite_ListView.vista;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.MT_Crud_Sqlite_ListView.R;
import com.example.MT_Crud_Sqlite_ListView.modelo.AdminSQLiteOpenHelper;
import com.example.MT_Crud_Sqlite_ListView.modelo.Persona;

import java.util.ArrayList;

public class ConsultaPersonas extends AppCompatActivity {

    ListView listViewPersonas;
    ArrayList<String>  listaDatos;
    ArrayList<Persona> listaPersona;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta_personas);

        listViewPersonas= findViewById(R.id.miListView);
        ObtienePersona();

        ArrayAdapter miAdaptador= new ArrayAdapter(this, android.R.layout.simple_list_item_1,listaDatos);
        listViewPersonas.setAdapter(miAdaptador);

        listViewPersonas.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                String informacion = "ID:" + listaPersona.get(position).getId();
                Toast.makeText(getApplicationContext(), informacion, Toast.LENGTH_SHORT).show();

                Persona pers=listaPersona.get(position);
                Intent intent= new Intent(getApplicationContext(),DetallePersona.class);
                Bundle bundle= new Bundle();
                bundle.putSerializable("persona", pers);
                intent.putExtras(bundle);
                startActivity(intent);
            }
       });
    }

    private void ObtienePersona(){

        AdminSQLiteOpenHelper admin= new AdminSQLiteOpenHelper(this, "administracion", null, 1);
        // abrir en modo lectura y escritura
        SQLiteDatabase BaseDeDatos= admin.getWritableDatabase();

        Persona persona=null;

        listaPersona= new ArrayList<Persona>();

        Cursor registro= BaseDeDatos.rawQuery("select * from persona",null);

            //Recorremos el cursor hasta que no haya más registros
            while(registro.moveToNext()){
                persona= new Persona();

                persona.setId(registro.getInt(0));
                persona.setCorreo(registro.getString(1));
                persona.setNombre(registro.getString(2));
                persona.setTelefono(registro.getString(3));
                persona.setFecha_nacimiento(registro.getString(4));
                persona.setPais(registro.getString(5));
                persona.setComentarios(registro.getString(6));
                listaPersona.add(persona);
            }
            BaseDeDatos.close();
            obtenerLista();
    }

    private void obtenerLista(){
        listaDatos = new ArrayList<String>();
        //listaDatos.add(" ID "+  "   Nombre     " + "     Correo     ");
        for (int i=0; i<listaPersona.size() ; i++){
            listaDatos.add(listaPersona.get(i).getId() +  "               " +
                           listaPersona.get(i).getCorreo()+"              " + listaPersona.get(i).getNombre());
        }
    }

    public void volver(View view) {
        finish();
    }


}