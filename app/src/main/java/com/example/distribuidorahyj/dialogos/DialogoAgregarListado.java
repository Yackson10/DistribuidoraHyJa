package com.example.distribuidorahyj.dialogos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

import com.example.distribuidorahyj.Activity.MainActivity;
import com.example.distribuidorahyj.R;
import com.example.distribuidorahyj.adaptadores.AdapterProducto;
import com.example.distribuidorahyj.dao.ProductoDAO;
import com.example.distribuidorahyj.domain.Producto;

public class DialogoAgregarListado extends DialogFragment {

    EditText codigo, descripcion, precio, disponible, tipoProducto;
    Context context;
    MainActivity mainActivity;
    AdapterProducto adapter;
    Producto producto = new Producto();
    ProductoDAO productoDAO;
    String item;

    public DialogoAgregarListado(Context context) {
        this.context = context;
        this.adapter = adapter;
    }

    public  void DialogoAgregarProducto(){
        Producto producto = new Producto();
        AlertDialog.Builder builder = new AlertDialog.Builder(context);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.dialogo_agregar_list,null);

        builder.setView(view);

        codigo = view.findViewById(R.id.codigoLis);
        descripcion = view.findViewById(R.id.descripcionLis);
        precio = view.findViewById(R.id.precioLis);
        //boolean dispo = ((Switch) view.findViewById(R.id.switch1Lis)).isChecked();
        //tipoProducto = view.findViewById(R.id.idSpinnerLis);




        builder.setTitle("Agregar Nuevo Producto ")

                .setPositiveButton("Agregar",
                        (dialog, which) -> {

                    producto.setCodigo(Integer.parseInt(codigo.getText().toString()));
                    producto.setDescripcion(descripcion.getText().toString());
                    producto.setPrecio(precio.getText().toString());
                    //producto.setDisponible(Boolean.getBoolean(disponible.getText().toString()));
                    //producto.setTipoProducto(tipoProducto.getText().toString());


                            productoDAO = new ProductoDAO(context);
                            productoDAO.Registrar(producto);

                            Toast.makeText(context, "Se ha registrado el producto", Toast.LENGTH_SHORT).show();

                        })
                .setNegativeButton("CANCELAR",
                        (dialog, which) -> dialog.cancel());

        builder.show();
    }
}
