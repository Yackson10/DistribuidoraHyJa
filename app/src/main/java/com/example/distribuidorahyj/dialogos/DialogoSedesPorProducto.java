package com.example.distribuidorahyj.dialogos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import androidx.appcompat.app.AlertDialog;

import com.example.distribuidorahyj.R;
import com.example.distribuidorahyj.domain.Producto;

public class DialogoSedesPorProducto {

    Context context;

    public DialogoSedesPorProducto(Context context) {
        this.context = context;
    }

    public void DialogoSedes(Producto producto) {

        AlertDialog.Builder builder = new AlertDialog.Builder(context);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.dialogo_sedes_por_producto,null);

        builder.setView(view);


        builder.setTitle("Desea Modificar el Producto ")

                .setPositiveButton("MODIFICAR",
                        (dialog, which) -> {


                        })
                .setNegativeButton("GUARDAR",
                        (dialog, which) -> dialog.cancel());

        builder.show();
    }
}

