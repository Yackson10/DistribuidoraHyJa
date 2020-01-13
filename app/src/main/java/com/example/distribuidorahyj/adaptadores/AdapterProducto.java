package com.example.distribuidorahyj.adaptadores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.distribuidorahyj.R;
import com.example.distribuidorahyj.dao.ProductoDAO;
import com.example.distribuidorahyj.domain.Producto;

import java.util.ArrayList;

public class AdapterProducto extends RecyclerView.Adapter<AdapterProducto.ViewHolderDatos> {

    public ArrayList<Producto> listDatos;
    private onItemClick mClickListener;
    private onItemClicks nClickListener;
    // private  onItemClicka aClickListener;
    ProductoDAO eliProducto;
    ProductoDAO modiProducto;

    public AdapterProducto(ArrayList<Producto> listDatos, ProductoDAO productoDAO) {
        this.listDatos = listDatos;
        this.eliProducto = productoDAO;
        this.modiProducto = productoDAO;
    }

    @Override
    public AdapterProducto.ViewHolderDatos onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_list, viewGroup, false);
        return new ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder(ViewHolderDatos viewHolderDatos, int i) {
        Producto producto = listDatos.get(i);

        viewHolderDatos.codigo.setText(String.valueOf(producto.getCodigo()));
        viewHolderDatos.descripcion.setText(producto.getDescripcion());
        viewHolderDatos.precio.setText(String.valueOf(producto.getPrecio()));
        viewHolderDatos.disponible.setText(String.valueOf(producto.isDisponible()));
        viewHolderDatos.tipoProducto.setText(producto.getTipoProducto());


        try {
            switch (producto.getTipoProducto()){
                case "Carnes":
                    viewHolderDatos.imagen.setImageResource(R.drawable.carnes);
                    break;
                case "Lateos":
                    viewHolderDatos.imagen.setImageResource(R.drawable.lateos);
                    break;
                case "Liquidos":
                    viewHolderDatos.imagen.setImageResource(R.drawable.liquido);
                    break;
                default:
                    viewHolderDatos.imagen.setImageResource(R.drawable.hielo);
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        viewHolderDatos.asignarEventos(producto, viewHolderDatos.getAdapterPosition());
        viewHolderDatos.asignarEvento(producto, viewHolderDatos.getAdapterPosition());
        //viewHolderDatos.agregarEventoProducto(producto,viewHolderDatos.getAdapterPosition());

    }

    @Override
    public int getItemCount() {
        return listDatos.size();
    }


    public class ViewHolderDatos extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView codigo;
        TextView descripcion;
        TextView precio;
        TextView disponible;
        TextView tipoProducto;
        ImageView imagen;

        ImageButton eliminar;
        ImageButton modificar;
        //ImageButton agregar;


        ViewHolderDatos(View itemView) {
            super(itemView);
            codigo = (TextView) itemView.findViewById(R.id.txtVcod);
            descripcion = (TextView) itemView.findViewById(R.id.txtVdes);
            precio = (TextView) itemView.findViewById(R.id.txtVpre);

            disponible = (TextView) itemView.findViewById(R.id.txtVdispo);
            tipoProducto = (TextView) itemView.findViewById(R.id.txtVtipoProducto);

            imagen = (ImageView) itemView.findViewById(R.id.imagen);

            //agregar = (ImageButton)itemView.findViewById(R.id.iconAgregar);
            eliminar = (ImageButton) itemView.findViewById(R.id.imageliminar);
            modificar = (ImageButton) itemView.findViewById(R.id.imageModificar);
            codigo.setOnClickListener(this);
        }

        private void asignarEventos(final Producto producto, final int pos) {
            eliminar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mClickListener != null) {
                        mClickListener.itemclick(v, producto);
                    }
                }
            });
        }

        private void asignarEvento(final Producto producto, final int pos) {
            modificar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (nClickListener != null) {
                        nClickListener.itemclicks(v, producto, pos);
                    }
                }
            });
        }

        /*private void agregarEventoProducto(final Producto producto, final int pos){
            agregar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (aClickListener != null) {
                        aClickListener.itemclicka(v,producto,pos);
                    }
                }
            });
        }*/

        @Override
        public void onClick(View v) {
        }
    }

    public interface onItemClick {
        void itemclick(View view, Producto producto);
    }

    public void setClickListener(onItemClick itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    public interface onItemClicks {
        void itemclicks(View view, Producto position, int pos);
    }

    public void setClickListeners(onItemClicks itemClicksListeners) {
        this.nClickListener = itemClicksListeners;
    }


    /*public interface onItemClicka {
        void itemclicka(View view, Producto position,int pos);
    }

    public void setClickListenerA(onItemClicka itemClicksListenerA){
        this.aClickListener = itemClicksListenerA;
    }*/
}
