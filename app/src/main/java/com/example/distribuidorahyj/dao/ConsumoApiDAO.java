package com.example.distribuidorahyj.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.example.distribuidorahyj.domain.Photos;
import com.example.distribuidorahyj.utils.AdminSQLiteOpenHelper;

public class ConsumoApiDAO {

    SQLiteDatabase baseDeDatos;

    public ConsumoApiDAO (Context contexto){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(contexto,"administracion", null, 1);
        baseDeDatos = admin.getWritableDatabase();
    }

    public boolean guardar(Photos obj){

        //SQLiteDatabase oConexion = consumoApi();

        ContentValues values = new ContentValues();
        Photos photo = new Photos();

        values.put(String.valueOf(photo.getAlbumId()),String.valueOf(obj.getAlbumId()));
        values.put(String.valueOf(photo.getId()),String.valueOf(obj.getId()));
        values.put(photo.getTitle(), obj.getTitle());
        values.put(photo.getUrl(), obj.getUrl());
        values.put(photo.getThumbnailUrl(), obj.getThumbnailUrl());

       // oConexion.insert("phosto",null,values);

        return true;
    }

    public Photos buscarApiConsumo(String id){

        Photos consumoApi = null;

        if(!id.isEmpty()){
            Cursor fila = baseDeDatos.rawQuery
                    ("select albumId, title, url, thumbnailUrl from phosto where id =" + id, null);

            if(fila.moveToFirst()){
                consumoApi = new Photos();
                consumoApi.setId(Integer.parseInt(id));
                consumoApi.setAlbumId(Integer.parseInt(fila.getString(0)));
                consumoApi.setTitle(fila.getString(1));
                consumoApi.setUrl(fila.getString(2));
                consumoApi.setThumbnailUrl(fila.getString(3));

                baseDeDatos.close();
            } else {
                baseDeDatos.close();
            }
        }
        return consumoApi;
    }
}
