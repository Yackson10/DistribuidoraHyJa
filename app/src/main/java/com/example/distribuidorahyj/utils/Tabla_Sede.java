package com.example.distribuidorahyj.utils;

public class Tabla_Sede {

    public static final String TABLA_SEDE="sede";
    public static final String CAMPO_CODIGOSEDE="codigoSede";
    public static final String CAMPO_NOMBRE="nombre";
    public static final String CAMPO_DESPARTAMENTO="departamento";


    public static final String CREAR_TABLA_SEDE="CREATE TABLE "+ TABLA_SEDE+" ("+CAMPO_CODIGOSEDE+" INTEGER primary key, "+CAMPO_NOMBRE+" TEXT, "+CAMPO_DESPARTAMENTO+" TEXT)";

}
