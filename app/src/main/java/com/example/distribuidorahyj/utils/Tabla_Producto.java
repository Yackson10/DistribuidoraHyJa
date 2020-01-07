package com.example.distribuidorahyj.utils;

public class Tabla_Producto {

    public static final String TABLA_ARTICULOS="articulos";
    public static final String CAMPO_CODIGO="codigo";
    public static final String CAMPO_DESCRIPCION="descripcion";
    public static final String CAMPO_PRECIO="precio";
    public static final String CAMPO_DISPONIBLE="disponible";
    public static final String CAMPO_TIPOPRODUCTO="tipoProducto";


    public static final String CREAR_TABLA_ARTICULOS="CREATE TABLE "+ TABLA_ARTICULOS+" ("+CAMPO_CODIGO+" INTEGER primary key, "+CAMPO_DESCRIPCION+" TEXT," + CAMPO_PRECIO+" TEXT, "+CAMPO_DISPONIBLE+" BOOLEAN, "+CAMPO_TIPOPRODUCTO+" TEXT)";

}
