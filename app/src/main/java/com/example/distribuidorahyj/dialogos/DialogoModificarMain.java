package com.example.distribuidorahyj.dialogos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

import com.example.distribuidorahyj.Activity.MainActivity;
import com.example.distribuidorahyj.Interface.IdialogoModificar;
import com.example.distribuidorahyj.R;
import com.example.distribuidorahyj.dao.ProductoDAO;
import com.example.distribuidorahyj.domain.Producto;

public class DialogoModificarMain extends DialogFragment implements IdialogoModificar {


    Context context;
    EditText descripcionMain, precioMain;
    IProducto mClickListener;
    ProductoDAO productoDAO;

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

        builder.setTitle("Desea Modificar el Producto " + producto.getCodigo())

                .setPositiveButton("MODIFICAR",
                        (dialog, which) -> {

                            producto.setDescripcion(descripcionMain.getText().toString());
                            producto.setPrecio(precioMain.getText().toString());

                            productoDAO = new ProductoDAO(context);
                            productoDAO.modificar(producto);

                            Toast.makeText(context, "Se a modificado el Producto " + producto.getCodigo(), Toast.LENGTH_SHORT).show();




                        })
                .setNegativeButton("CANCELAR",
                        (dialog, which) -> dialog.cancel());
        builder.show();
    }

    public interface IProducto{
        void modificar(View view,Producto producto);
    }

}







