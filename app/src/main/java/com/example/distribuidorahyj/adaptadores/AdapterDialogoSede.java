package com.example.distribuidorahyj.adaptadores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.distribuidorahyj.R;
import com.example.distribuidorahyj.domain.Producto;

import java.util.ArrayList;

public class AdapterDialogoSede extends RecyclerView.Adapter<AdapterDialogoSede.ViewHolderListaProducto>{

    ArrayList<Producto> listProductoAlert;

    public AdapterDialogoSede(ArrayList<Producto> listProductoAlert) {
        this.listProductoAlert = listProductoAlert;
    }


    @NonNull
    @Override
    public ViewHolderListaProducto onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_dialogo_sede,parent,false);
        return new ViewHolderListaProducto(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderListaProducto holder, int position) {

        Producto producto = listProductoAlert.get(position);

        holder.codigo.setText(String.valueOf(producto.getCodigo()));
        holder.descripcion.setText(producto.getDescripcion());
        holder.precio.setText(String.valueOf(producto.getPrecio()));
        holder.disponible.setText(String.valueOf(producto.isDisponible()));
        holder.tipoProducto.setText(producto.getTipoProducto());
    }

    @Override
    public int getItemCount() {
        return listProductoAlert.size();
    }

    public class ViewHolderListaProducto extends RecyclerView.ViewHolder {

        TextView codigo;
        TextView descripcion;
        TextView precio;
        TextView disponible;
        TextView tipoProducto;

        public ViewHolderListaProducto(@NonNull View itemView) {
            super(itemView);

            codigo=(TextView)itemView.findViewById(R.id.txtVcod1);
            descripcion=(TextView)itemView.findViewById(R.id.txtVdes2);
            precio=(TextView)itemView.findViewById(R.id.txtVpre3);
            disponible=(TextView)itemView.findViewById(R.id.txtVdispo4);
            tipoProducto= (TextView)itemView.findViewById(R.id.txtVtipoProducto5);
        }

    }
}

