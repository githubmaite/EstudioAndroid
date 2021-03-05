package com.example.MT_Crud_Sqlite_ListView.modelo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

    public class AdminSQLiteOpenHelper extends SQLiteOpenHelper {

        //final String CREAR_TABLA_PERSONA="CREATE TABLE persona(id int primary key, correo text, nombre text, telefono int, pais text, comentario txt)";
        // constructor

        public AdminSQLiteOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        //metodos
        @Override
        public void onCreate(SQLiteDatabase BaseDeDatos) {

            //BaseDeDatos.execSQL("create table persona(id int primary key, correo text, nombre text, telefono int, fecnac int, pais text, comentario txt)");
            BaseDeDatos.execSQL("create table persona(id int primary key, correo text, nombre text, telefono text, fecnac text, pais text, comentario txt)");
        }

        @Override
        public void onUpgrade(SQLiteDatabase BaseDeDatos, int i, int i1) {

        }
    }
