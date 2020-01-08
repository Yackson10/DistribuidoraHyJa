package com.example.distribuidorahyj.utils;

public class Tabla_Cliente {

    public static final String TABLA_CLIENTE="cliente";
    public static final String CAMPO_ID="idCliente";
    public static final String CAMPO_NOMBRE="nombre";
    public static final String CAMPO_APELLIDO="apellido";
    public static final String CAMPO_TELEFONO="telefono";
    public static final String CAMPO_CORREO="correo";


    public static final String CREAR_TABLA_CLIENTE="CREATE TABLE "+ TABLA_CLIENTE+" ("+CAMPO_ID+" INTEGER primary key, "+CAMPO_NOMBRE+" TEXT," + CAMPO_APELLIDO+" TEXT, "+CAMPO_TELEFONO+" TEXT, "+CAMPO_CORREO+" TEXT)";


}

