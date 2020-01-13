package com.example.distribuidorahyj.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.distribuidorahyj.domain.Producto;
import com.example.distribuidorahyj.utils.AdminSQLiteOpenHelper;

public class ProductoDAO {

    SQLiteDatabase baseDeDatos;

    public ProductoDAO(Context context) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(context, "BaseDeDatosDistri", null, 1);
        baseDeDatos = admin.getWritableDatabase();
    }

    public int eliminar(Producto producto) {
        return baseDeDatos.delete("articulos", "codigo=" + producto.getCodigo(), null);
    }

    public int modificar(Producto producto) {

        ContentValues registro = new ContentValues();

        registro.put("codigo", producto.getCodigo());
        registro.put("descripcion", producto.getDescripcion());
        registro.put("precio", producto.getPrecio());
        registro.put("disponible", producto.isDisponible());
        registro.put("tipoProducto", producto.getTipoProducto());

        return baseDeDatos.update("articulos", registro, "codigo=" + producto.getCodigo(), null);

    }

    public Producto buscar(String buscar) {

        Producto producto = null;
        String where = "";

        if (!buscar.isEmpty()) {

            where = " where codigo LIKE '%" + buscar + "%' or  descripcion LIKE '%" + buscar + "%'";
        }

        Cursor cursor = baseDeDatos.rawQuery
                ("select * from articulos " + where, null);

        if (cursor.moveToFirst()) {
            producto = new Producto();
            boolean result;

            if(cursor.getString(3).equals("1")){
                result = true;
            }else {
                result = false;
            }

            producto.setCodigo(Integer.parseInt(cursor.getString(0)));
            producto.setDescripcion(cursor.getString(1));
            producto.setPrecio(cursor.getString(2));
            producto.setDisponible(result);
            producto.setTipoProducto(cursor.getString(4));


            String x = cursor.getString(3);
            baseDeDatos.close();
        }
        return producto;
    }

    public boolean Registrar(Producto producto) {

        ContentValues agregar = new ContentValues();

        agregar.put("codigo", producto.getCodigo());
        agregar.put("descripcion", producto.getDescripcion());
        agregar.put("precio", producto.getPrecio());
        agregar.put("disponible", producto.isDisponible());
        agregar.put("tipoProducto", producto.getTipoProducto());

        long result = baseDeDatos.insert("articulos", null, agregar);

        if (result == -1)
            return false;
        else
            return true;
    }

}

