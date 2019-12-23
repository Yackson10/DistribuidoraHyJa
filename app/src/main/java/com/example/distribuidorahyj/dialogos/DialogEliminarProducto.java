package com.example.distribuidorahyj.dialogos;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

import com.example.distribuidorahyj.Activity.MainActivity;
import com.example.distribuidorahyj.R;
import com.example.distribuidorahyj.domain.Producto;

public class DialogEliminarProducto {


    EditText et_codigo;
    Producto producto;
    MainActivity activity;
    Context context;

    public void dialogoEliminar() {

            String mensaje;

            String codigo = et_codigo.getText().toString();

            if (!codigo.isEmpty()) {
                mensaje = "Desea eliminar el producto # " + producto.getCodigo();
            } else {
                mensaje = "Debe de ingresar el campo Còdigo para eliminar el producto";
            }

            AlertDialog.Builder alerta = new AlertDialog.Builder(context);
            alerta.setMessage(mensaje)
                    .setCancelable(false)

                    .setPositiveButton(" SI ", (dialog, which) -> {
                        activity.eliminar(producto);
                        dialog.dismiss();
                    })
                    .setNegativeButton(" NO ", (dialog, which) -> dialog.cancel());
            AlertDialog titulo = alerta.create();
            titulo.setTitle("Eliminar Producto");
            titulo.show();
    }
}
