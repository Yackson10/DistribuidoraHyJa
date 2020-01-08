package com.example.distribuidorahyj.dialogos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

import com.example.distribuidorahyj.Activity.MainActivity;
import com.example.distribuidorahyj.R;
import com.example.distribuidorahyj.adaptadores.AdapterProducto;
import com.example.distribuidorahyj.dao.ProductoDAO;
import com.example.distribuidorahyj.domain.Producto;

public class DialogoAgregarListado extends DialogFragment {

    Context context;
    MainActivity mainActivity;
    AdapterProducto adapter;
    Producto product = new Producto();

    public DialogoAgregarListado(Context context) {
        this.context = context;
        this.adapter = adapter;
    }

    public  void DialogoAgregarProducto(Producto product){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.dialogo_agregar_list,null);

        builder.setView(view);

        //descripcionMain =view.findViewById(R.id.dialogoAgregarDescripcionMain);
        //precioMain = view.findViewById(R.id.dialogoAgregarPrecioMain);

        //descripcionMain.setText(producto.getDescripcion());
        //precioMain.setText(String.valueOf(producto.getPrecio()));

        builder.setTitle("Agregar Nuevo Producto ")

                .setPositiveButton("Agregar",
                        (dialog, which) -> {

                            //producto.setDescripcion(descripcionMain.getText().toString());
                            //producto.setPrecio(precioMain.getText().toString());

                            //mainActivity.agregar(view);
                            //productoDAO = new ProductoDAO(context);
                            //productoDAO.Registrar(product);

                            //adapter.listDatos.set(producto,pos);
                            //adapter.notifyItemChanged(producto, );

                            Toast.makeText(context, "Se ha registrado el producto" + product.getCodigo(), Toast.LENGTH_SHORT).show();

                        })
                .setNegativeButton("CANCELAR",
                        (dialog, which) -> dialog.cancel());

        builder.show();
    }
}
