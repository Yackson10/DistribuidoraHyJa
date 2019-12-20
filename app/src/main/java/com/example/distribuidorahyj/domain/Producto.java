package com.example.distribuidorahyj.domain;

import java.util.ArrayList;

public class  Producto {

    private int codigo;
    private String descripcion;
    private int precio;
    private boolean disponible;

    public Producto() {
    }

    public Producto(int codigo, String descripcion, int precio, boolean disponible) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precio = precio;
        this.disponible = disponible;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public String getCodigo() {
        return String.valueOf(codigo);
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {

        this.precio = precio;
    }

    public String toString() {return descripcion;}


    public static ArrayList<Producto> getProducto(String string){
        ArrayList<Producto> productos = new ArrayList<>();
        productos.add(new Producto(0,"Seleccione", 1000, true));
        productos.add(new Producto(1,"Lateos", 12000, true));
        productos.add(new Producto(2,"Carnes", 15000, true));
        productos.add(new Producto(3,"Frios", 16000, true));
        productos.add(new Producto(4,"Liquidos", 18000, true));
        return productos;

    }

}
