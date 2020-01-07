package com.example.distribuidorahyj.domain;
import java.io.Serializable;

public class  Producto implements Serializable {


    private int codigo;
    private String descripcion;
    private String precio;
    private boolean disponible;
    private String tipoProducto;
    private int foto;

    public Producto() {
    }

    public Producto(int foto, int codigo, String descripcion, String precio, boolean disponible, String tipoProducto) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precio = precio;
        this.disponible = disponible;
        this.tipoProducto = tipoProducto;
        this.foto = foto;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
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

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {

        this.precio = precio;
    }

    public String getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(String tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    public String toString() {return descripcion;}


    /*public static ArrayList<Producto> getProducto(String string){
        ArrayList<Producto> productos = new ArrayList<>();
        productos.add(new Producto(-1,"Tipo de Producto", "1000", true));
        productos.add(new Producto(0,"Lateos", "12000", true));
        productos.add(new Producto(1,"Carnes", "15000", true));
        productos.add(new Producto(2,"Frios", "16000", true));
        productos.add(new Producto(3,"Liquidos", "18000", true));
        return productos;

    }*/

}
