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
        baseDeDatos.execSQL(Tabla_Cliente.CREAR_TABLA_CLIENTE);
        baseDeDatos.execSQL(Tabla_Photos.CREAR_TABLA_PHOTOS);
        baseDeDatos.execSQL(Tabla_Producto.CREAR_TABLA_ARTICULOS);
        baseDeDatos.execSQL(Tabla_Sede.CREAR_TABLA_SEDE);
        baseDeDatos.execSQL(Tabla_ProductoXSede.CREAR_TABLA_PRODUCTOXSEDE);

        cargarDatos(baseDeDatos);

    }

    @Override
    public void onUpgrade(SQLiteDatabase baseDeDatos, int i, int i1) {
        baseDeDatos.execSQL("DROP TABLE IF EXISTS photos");
        baseDeDatos.execSQL("DROP TABLE IF EXISTS producto");
        baseDeDatos.execSQL("DROP TABLE IF EXISTS sede");
        baseDeDatos.execSQL("DROP TABLE IF EXISTS productoXSede");
        baseDeDatos.execSQL("DROP TABLE IF EXISTS cliente");

        onCreate(baseDeDatos);
    }

    public void cargarDatos(SQLiteDatabase baseDeDatos){
        baseDeDatos.execSQL("INSERT INTO sede VALUES('1','Manrique','Medellin')");
        baseDeDatos.execSQL("INSERT INTO sede VALUES('2','Aranjuez','Cali')");
        baseDeDatos.execSQL("INSERT INTO sede VALUES('3','CampoValdez','Barranquilla')");
        baseDeDatos.execSQL("INSERT INTO sede VALUES('4','SanPablo','Bogota')");
        baseDeDatos.execSQL("INSERT INTO sede VALUES('5','Granizal','Pasto')");
        baseDeDatos.execSQL("INSERT INTO sede VALUES('6','LaSalle','Cartagena')");

    }
}



