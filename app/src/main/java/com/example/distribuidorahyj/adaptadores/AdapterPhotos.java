package com.example.distribuidorahyj.adaptadores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.distribuidorahyj.R;
import com.example.distribuidorahyj.domain.Photos;

import java.util.List;

public class AdapterPhotos extends  RecyclerView.Adapter<AdapterPhotos.ViewHolder> {

    List<Photos> listPhotos;

    public AdapterPhotos(List<Photos> listPhotos) {
        this.listPhotos = listPhotos;
    }

    @Override
    public AdapterPhotos.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_recycler,parent,false);
        ViewHolder viewHolder = new ViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int i) {
        Photos photos = listPhotos.get(i);

        holder.album.setText(String.valueOf(photos.getAlbumId()));
        holder.id.setText(String.valueOf(photos.getId()));
        holder.titulo.setText(photos.getTitle());
        holder.url.setText(photos.getUrl());
        holder.thumbnailURL.setText(photos.getThumbnailUrl());
    }

    @Override
    public int getItemCount() {
        return listPhotos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView album, id, titulo, url, thumbnailURL;

         public ViewHolder(View itemView) {
            super(itemView);
            album = (TextView)itemView.findViewById(R.id.album);
            id = (TextView)itemView.findViewById(R.id.id);
            titulo = (TextView)itemView.findViewById(R.id.titulo);
            url = (TextView)itemView.findViewById(R.id.url);
            thumbnailURL = (TextView)itemView.findViewById(R.id.thum);

        }
    }

    public void setItems(List<Photos> items){
        this.listPhotos = items;
        notifyDataSetChanged();
    }
}
