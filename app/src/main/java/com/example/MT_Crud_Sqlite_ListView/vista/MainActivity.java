package com.example.MT_Crud_Sqlite_ListView.vista;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.MT_Crud_Sqlite_ListView.R;


public class MainActivity extends AppCompatActivity {

         @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
        }

        public  void  evento(View view) {

            switch (view.getId()){

                case R.id.btnformulario:

                    Intent miIntent1= new Intent(this,Formulario.class);
                    startActivity(miIntent1);
                    //Toast.makeText(this,"Usuario :"+usuario+" Passw" +numpassw,Toast.LENGTH_SHORT).show();
                    break;


                case R.id.btnListado:
                    Intent miIntent4= new Intent(this,ConsultaPersonas.class);
                    startActivity(miIntent4);
                    break;

            }
        }

}