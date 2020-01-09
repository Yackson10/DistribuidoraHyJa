package com.example.distribuidorahyj.domain;

import java.io.Serializable;
import java.util.ArrayList;

public class Sede implements Serializable {

    int codigo;
    String nombre;
    String departamento;

    public Sede() {
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

    /*public static ArrayList<Sede> getSede(String string){
        ArrayList<Sede> sede = new ArrayList<>();
        sede.add(new Sede(0,"La casita", "Antioquia"));
        sede.add(new Sede(1,"La ", "Antioquia"));
        //sede.add(new Producto(0,"Lateos", "12000", true));
        //sede.add(new Producto(1,"Carnes", "15000", true));
        //sede.add(new Producto(2,"Frios", "16000", true));

        return sede;

    }*/
}

    /*public static ArrayList<Producto> getProducto(String string){
        ArrayList<Producto> productos = new ArrayList<>();
        productos.add(new Producto(-1,"Tipo de Producto", "1000", true));
        productos.add(new Producto(0,"Lateos", "12000", true));
        productos.add(new Producto(1,"Carnes", "15000", true));
        productos.add(new Producto(2,"Frios", "16000", true));
        productos.add(new Producto(3,"Liquidos", "18000", true));
        return productos;*/
