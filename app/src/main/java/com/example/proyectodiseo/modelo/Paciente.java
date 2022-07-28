package com.example.proyectodiseo.modelo;

public class Paciente {
    static String nombre;
    static String apellido;

    public Paciente(){}

    public Paciente(String nombre, String apellido){
        this.nombre=nombre;
        this.apellido=apellido;
    }

    public static String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    public static String getApellido(){
        return apellido;
    }
    public void setApellido(String apellido){
        this.apellido=apellido;
    }
}
