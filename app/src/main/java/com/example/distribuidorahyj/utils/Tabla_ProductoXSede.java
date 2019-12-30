package com.example.distribuidorahyj.utils;

public class Tabla_ProductoXSede {

    public static final String TABLA_PRODUCTOXSEDE="ProductoXSede";
    public static final String CAMPO_CODIGOPRODUCTO="codigoProducto";
    public static final String CAMPO_CODIGOSEDE="codigoSede";
    public static final String CAMPO_ACTIVO="activo";


    public static final String CREAR_TABLA_PRODUCTOXSEDE="CREATE TABLE "+ TABLA_PRODUCTOXSEDE+" ("+CAMPO_CODIGOPRODUCTO+" INTEGER primary key AUTOIMCREMENT, "+CAMPO_CODIGOSEDE+" STRING, "+CAMPO_ACTIVO+" STRING)";

}

