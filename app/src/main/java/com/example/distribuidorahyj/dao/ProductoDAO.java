package com.example.distribuidorahyj.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.distribuidorahyj.Activity.MainActivity;
import com.example.distribuidorahyj.domain.Producto;
import com.example.distribuidorahyj.utils.AdminSQLiteOpenHelper;

public class ProductoDAO {

    SQLiteDatabase baseDeDatos;

    public ProductoDAO(Context context) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(context, "administracion", null, 1);
        baseDeDatos = admin.getWritableDatabase();
    }

    public int eliminar(Producto producto) {
        return baseDeDatos.delete("articulos", "codigo =" + producto.getCodigo(), null);
    }

    public int modificar(Producto producto) {

        ContentValues registro = new ContentValues();

        registro.put("codigo", producto.getCodigo());
        registro.put("descripcion", producto.getDescripcion());
        registro.put("precio", producto.getPrecio());

        return baseDeDatos.update("articulos", registro, "codigo=" + producto.getCodigo(), null);

    }

    public Producto buscar(String codigo) {

        Producto producto = null;

        Cursor fila = baseDeDatos.rawQuery
                ("select descripcion, precio from articulos where codigo =" + codigo, null);

        if (fila.moveToFirst()) {
            producto = new Producto();
            producto.setCodigo(Integer.parseInt(codigo));
            producto.setDescripcion(fila.getString(0));
            producto.setPrecio(Integer.parseInt(fila.getString(1)));

            baseDeDatos.close();
        }
        return producto;
    }

    public void Registrar(Producto producto) {

        Cursor fila = baseDeDatos.rawQuery
                ("select descripcion, precio from articulos where codigo =" + producto.getCodigo(), null);

        if (fila.moveToFirst()) {
            baseDeDatos.close();
        } else {

            ContentValues agregar = new ContentValues();

            agregar.put("codigo", producto.getCodigo());
            agregar.put("descripcion", producto.getDescripcion());
            agregar.put("precio", producto.getPrecio());

            baseDeDatos.insert("articulos", null, agregar);
        }
    }
}
