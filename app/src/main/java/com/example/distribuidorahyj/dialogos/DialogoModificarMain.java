package com.example.distribuidorahyj.dialogos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

import com.example.distribuidorahyj.Activity.MainActivity;
import com.example.distribuidorahyj.Interface.IdialogoModificar;
import com.example.distribuidorahyj.R;
import com.example.distribuidorahyj.domain.Producto;

public class DialogoModificarMain extends DialogFragment implements IdialogoModificar {

    Context context;
    MainActivity mainActivity = new MainActivity();
    EditText descripcionMain, precioMain;

    public DialogoModificarMain(Context context) {
        this.context = context;
    }

    @Override
    public void modificarDialogo(Producto producto) {

        AlertDialog.Builder builder = new AlertDialog.Builder(context);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.dialogo_modificar_main,null);

        builder.setView(view);

        descripcionMain =view.findViewById(R.id.dialogoAgregarDescripcionMain);
        precioMain = view.findViewById(R.id.dialogoAgregarPrecioMain);

        descripcionMain.setText(producto.getDescripcion());
        precioMain.setText(String.valueOf(producto.getPrecio()));

        builder.setTitle("Desea Modificar el Producto ")

                .setPositiveButton("MODIFICAR",
                        (dialog, which) -> {

                            mainActivity.modificarDialogo(producto);
                            //productoDAO.modificar(producto);
                            //productoModificarDialogo.modificarDialogo(producto);

                            producto.setDescripcion(descripcionMain.getText().toString());
                            producto.setPrecio(Integer.parseInt(precioMain.getText().toString()));

                            dismiss();
                        })
                .setNegativeButton("CANCELAR",
                        (dialog, which) -> dialog.cancel());
        builder.show();
    }
}
//asfasgdfgdfaaaa