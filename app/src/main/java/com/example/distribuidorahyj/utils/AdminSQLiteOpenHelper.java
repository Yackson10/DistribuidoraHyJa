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
        //baseDeDatos.execSQL("create table articulos(codigo int primary key, descripcion text, precio real, disponible boolean)");
        baseDeDatos.execSQL("create table cliente(id int primary key )");
        //baseDeDatos.execSQL("create table photos(albumId int primary key, id int, title text, url text, thumbnailUrl text)");
        baseDeDatos.execSQL(Tabla_Photos.CREAR_TABLA_PHOTOS);
        baseDeDatos.execSQL(Tabla_Producto.CREAR_TABLA_PRODUCTO);
        baseDeDatos.execSQL(Tabla_Sede.CREAR_TABLA_SEDE);
        baseDeDatos.execSQL(Tabla_ProductoXSede.CREAR_TABLA_PRODUCTOXSEDE);
        //GGHGgit status
    }

    @Override
    public void onUpgrade(SQLiteDatabase baseDeDatos, int i, int i1) {
        baseDeDatos.execSQL("DROP TABLE IF EXISTS photos");
        baseDeDatos.execSQL("DROP TABLE IF EXISTS producto");
        baseDeDatos.execSQL("DROP TABLE IF EXISTS sede");
        baseDeDatos.execSQL("DROP TABLE IF EXISTS productoXSede");

        onCreate(baseDeDatos);
    }


}



