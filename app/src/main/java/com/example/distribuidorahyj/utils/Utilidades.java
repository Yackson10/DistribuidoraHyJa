package com.example.distribuidorahyj.utils;

public class Utilidades {

    //Contantes campos tabla Photos
    public static final String TABLA_PHOTOS="photos";
    public static final String CAMPO_ALBUMID="albumId";
    public static final String CAMPO_ID="Id";
    public static final String CAMPO_TITLE="title";
    public static final String CAMPO_URL="url";
    public static final String CAMPO_THUMBNAILURL="thumbnailUrl";


    public static final String CREAR_TABLA_PHOTOS="CREATE TABLE "+ TABLA_PHOTOS+" ("+CAMPO_ALBUMID+" INTEGER primary key, "+CAMPO_ID+" INTEGER, "+CAMPO_TITLE+" TEXT, "+CAMPO_URL+" TEXT, "+CAMPO_THUMBNAILURL+" TEXT)";


}
