package com.example.distribuidorahyj.utils;

import android.content.Context;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class AdminSQLiteOpenHelper extends SQLiteOpenHelper{

    public AdminSQLiteOpenHelper(Context context, String bd, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, bd, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase baseDeDatos) {
        //baseDeDatos.execSQL("create table sede(codigo int primary key, nombre text, Departamento text)");
        baseDeDatos.execSQL("create table cliente(id int primary key)");
        //baseDeDatos.execSQL("create table s(albumId int primary key, id int, title text, url text, thumbnailUrl text)");
        baseDeDatos.execSQL(Tabla_Photos.CREAR_TABLA_PHOTOS);
        baseDeDatos.execSQL(Tabla_Producto.CREAR_TABLA_ARTICULOS);
        baseDeDatos.execSQL(Tabla_Sede.CREAR_TABLA_SEDE);
        baseDeDatos.execSQL(Tabla_ProductoXSede.CREAR_TABLA_PRODUCTOXSEDE);
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
//dsf


