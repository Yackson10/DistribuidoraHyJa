package com.example.distribuidorahyj.domain;

import java.util.ArrayList;

public class Sede {

    int codigo;
    String nombre;
    String departamento;

    public Sede(int codigo, String nombre, String departamento) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.departamento = departamento;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public static ArrayList<Sede> getSede(String string){
        ArrayList<Sede> sede = new ArrayList<>();
        // sede.add(new Producto());
        //sede.add(new Producto(0,"Lateos", "12000", true));
        //sede.add(new Producto(1,"Carnes", "15000", true));
        //sede.add(new Producto(2,"Frios", "16000", true));

        return sede;

    }
}
