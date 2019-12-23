package com.example.distribuidorahyj.dialogos;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;

import com.example.distribuidorahyj.R;
import com.example.distribuidorahyj.adaptadores.AdapterProducto;
import com.example.distribuidorahyj.dao.ProductoDAO;
import com.example.distribuidorahyj.domain.Producto;

public class DialogModificarList {

    private EditText descripciones, precios;
    AdapterProducto adapter;
    ProductoDAO productoDAO;
    Context context;

    public DialogModificarList(AdapterProducto adapter, Context context) {
        this.adapter = adapter;
        this.context = context;
    }

    public void itemclickd(final Producto producto, final int pos) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View views = inflater.inflate(R.layout.dialogfragmen, null);

        descripciones =  views.findViewById(R.id.dialogDescripcion);
        precios = views.findViewById(R.id.dialogPrecio);

        descripciones.setText(producto.getDescripcion());
        precios.setText(String.valueOf(producto.getPrecio()));

        AlertDialog.Builder dialogo = new AlertDialog.Builder(context)
                .setView(views)

                .setTitle("Desea Modificar el producto # " + producto.getCodigo())

                .setPositiveButton("Modificar",
                        (DialogInterface dialog, int id) -> {

                            modificar(producto);

                            producto.setDescripcion(descripciones.getText().toString());
                            producto.setPrecio(Integer.parseInt(precios.getText().toString()));

                            adapter.listDatos.set(pos, producto);
                            adapter.notifyItemChanged(pos);

                            dialog.dismiss();
                        })
                .setNegativeButton("salir", (dialog, id) -> dialog.cancel());
        dialogo.show();
    }

    public void modificar(Producto producto) {

        String descripcion = descripciones.getText().toString();
        String precio = precios.getText().toString();

        //if (!producto.getCodigo().isEmpty()) {

        //bjkfndkvnjkdasnvjkad
            if (!producto.getCodigo().isEmpty() && !descripcion.isEmpty() && !precio.isEmpty()) {

                productoDAO = new ProductoDAO(context);
                productoDAO.modificar(producto);

            }
        //}
    }
}
