package com.example.distribuidorahyj.utils;

public class Tabla_Producto {

    public static final String TABLA_PRODUCTO = "producto";
    public static final String CAMPO_CODIGO = "codigo";
    public static final String CAMPO_DESCRIPCION = "descripcion";
    public static final String CAMPO_PRECIO = "precio";
    public static final String CAMPO_DISPONIBLE = "disponible";


    public static final String CREAR_TABLA_PRODUCTO = "CREATE TABLE " + TABLA_PRODUCTO + " (" + CAMPO_CODIGO + " INTEGER primary key, " + CAMPO_DESCRIPCION + " TEXT, " + CAMPO_PRECIO + " INTEGER, " + CAMPO_DISPONIBLE + " BOOLEAN)";
}
