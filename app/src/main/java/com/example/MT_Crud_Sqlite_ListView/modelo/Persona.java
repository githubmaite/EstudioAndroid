package com.example.MT_Crud_Sqlite_ListView.modelo;

import java.io.Serializable;

public class Persona implements Serializable {

   // Al agregar  Serializable te permite pasarlo como parametro

    private int id;
    private String correo;
    private String nombre;
    private String telefono;
    private String fecha_nacimiento;
    private String pais;
    private String comentarios;

    public Persona(int id,String correo, String nombre, String telefono, String fecha_nacimiento, String pais, String comentarios) {
        this.id=id;
        this.correo = correo;
        this.nombre = nombre;
        this.telefono = telefono;
        this.fecha_nacimiento = fecha_nacimiento;
        this.pais = pais;
        this.comentarios = comentarios;
    }
    public Persona() {

    }

    public int getId() {
        return id;
    }

    public String getCorreo() {
        return correo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public String getPais() {
        return pais;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }
}
