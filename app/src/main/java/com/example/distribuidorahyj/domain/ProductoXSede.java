package com.example.distribuidorahyj.domain;

public class ProductoXSede {

    private int codigoProducto;
    private int codigoSede;
    private Boolean activo;

    public ProductoXSede() {
    }

    public ProductoXSede(int codigoProducto, int codigoSede, Boolean activo) {
        this.codigoProducto = codigoProducto;
        this.codigoSede = codigoSede;
        this.activo = activo;
    }

    public int getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(int codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public int getCodigoSede() {
        return codigoSede;
    }

    public void setCodigoSede(int codigoSede) {
        this.codigoSede = codigoSede;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }
}
