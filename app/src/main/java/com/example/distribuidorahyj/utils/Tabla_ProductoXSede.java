package com.example.distribuidorahyj.utils;


public class Tabla_ProductoXSede {

    public static final String TABLA_PRODUCTOXSEDE="ProductoXSede";
    public static final String CAMPO_CODIGOPRODUCTO="codigo";
    public static final String CAMPO_CODIGOSEDE="codigoSede";
    public static final String CAMPO_ACTIVO="activo";


    public static final String CREAR_TABLA_PRODUCTOXSEDE="CREATE TABLE "+ TABLA_PRODUCTOXSEDE+" ("+CAMPO_CODIGOPRODUCTO+" INTEGER primary key , "+CAMPO_CODIGOSEDE+" TEXT, "+CAMPO_ACTIVO+" BOOLEAN)";

    public static final String n =  ("SELECT sede.codigoSede, articulos.coodigo as descripcion FROM sede INNER JOIN articulos ON articulos.codigo = sede.codigoSede");


}
