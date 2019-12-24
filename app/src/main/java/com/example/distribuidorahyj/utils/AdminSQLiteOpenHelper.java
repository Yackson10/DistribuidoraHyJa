package com.example.distribuidorahyj.utils;

import android.content.Context;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class AdminSQLiteOpenHelper extends SQLiteOpenHelper{
    //public  static final int BD_VERSION = 1;

    public AdminSQLiteOpenHelper(Context context, String bd, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, bd, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase baseDeDatos) {
        baseDeDatos.execSQL(Tabla_Producto.CREAR_TABLA_ARTICULOS);
        //baseDeDatos.execSQL("create table articulos(codigo int primary key, descripcion text, precio real, disponible boolean)");
        baseDeDatos.execSQL("create table cliente(id int primary key)");
        //baseDeDatos.execSQL("create table photos(albumId int primary key, id int, title text, url text, thumbnailUrl text)");
        baseDeDatos.execSQL(Tabla_Photos.CREAR_TABLA_PHOTOS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase baseDeDatos, int i, int i1) {
        baseDeDatos.execSQL("DROP TABLE IF EXISTS articulos");
        baseDeDatos.execSQL("DROP TABLE IF EXISTS photos");
        onCreate(baseDeDatos);
    }


}



