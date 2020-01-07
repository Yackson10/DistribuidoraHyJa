package com.example.distribuidorahyj.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.example.distribuidorahyj.Interface.JsonplaceholderApi;
import com.example.distribuidorahyj.ServiceApi;
import com.example.distribuidorahyj.R;
import com.example.distribuidorahyj.domain.Photos;
import com.example.distribuidorahyj.adaptadores.AdapterPhotos;
import com.example.distribuidorahyj.utils.AdminSQLiteOpenHelper;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ConsumoApi extends AppCompatActivity {

    Button guardarApi;
    TextView albumId, id, title, url, thumbnailUrl;
    RecyclerView recyclerView;
    AdapterPhotos adapter;
    ArrayList<Photos> listPhotos = new ArrayList<>();
    ArrayList<Photos> listPhotosDB = new ArrayList<>();
    private EditText buscarApiId;
    JsonplaceholderApi json;
    ProgressBar progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consumo_api);

        albumId = (TextView) findViewById(R.id.album);
        id = (TextView) findViewById(R.id.id);
        title = (TextView) findViewById(R.id.titulo);
        url = (TextView) findViewById(R.id.url);
        thumbnailUrl = (TextView) findViewById(R.id.thum);
        progressDialog = (ProgressBar) findViewById(R.id.progressId);


        buscarApiId = (EditText) findViewById(R.id.textBuscarApi);
        guardarApi = (Button) findViewById(R.id.btnGuardarApi);
        recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        adapter = new AdapterPhotos(listPhotos);
        recyclerView.setAdapter(adapter);


        json = ServiceApi.getRetrofit();
        Call<List<Photos>> call = json.getPhotos();


        call.enqueue(new Callback<List<Photos>>() {
            @Override
            public void onResponse(Call<List<Photos>> call, Response<List<Photos>> response) {
                if (response.isSuccessful()) {
                    listPhotos.addAll(response.body());
                    listPhotosDB.addAll(response.body());

                    progressDialog.setVisibility(recyclerView.GONE);
                    adapter.setItems(listPhotos);


                }
            }

            @Override
            public void onFailure(Call<List<Photos>> call, Throwable t) {
            }
        });

        guardarApi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (Photos list : listPhotos
                ) {
                    //guardar(list);
                }
            }
        });



        /*buscarApiId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog = new ProgressDialog(ConsumoApi.this);
                progressDialog.setMax(100);
                progressDialog.setMessage("Cargando");
                progressDialog.setTitle("Cargando");
                progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                progressDialog.show();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try{
                            while(progressDialog.getProgress() <= progressDialog.getMax()){
                                Thread.sleep(200);
                            }
                        }catch (Exception e){
                            e.printStackTrace();

                        }
                    }
                }).start();
            }
        });
    }
    Handler handler = new Handler(){
        public void handleMessage(Message msg){
            super.handleMessage(msg);
            progressDialog.incrementProgressBy(1);
        }
    };*/

    }

        public void url(View v) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url.getText().toString()));
            startActivity(intent);
        }


    public void buscarApi(View view) {

        String id = buscarApiId.getText().toString();

        ArrayList<Photos> listPhotosfilter;
        if (id.isEmpty()) {
            adapter.setItems(listPhotosDB);
            Toast.makeText(this, "Si deseas buscar Ingrese el id", Toast.LENGTH_SHORT).show();
        } else {
            for (Photos photo : listPhotosDB
            ) {
                if (photo.getId() == Integer.parseInt(id)) {

                    listPhotosfilter = new ArrayList<>();
                    listPhotosfilter.add(photo);

                    adapter.setItems(listPhotosfilter);

                    break;
                }
            }
        }
    }

    public void intentRegresar(View v) {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }

    public SQLiteDatabase consumoApiConexion() {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "BaseDeDatosDistri", null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();
        return BaseDeDatos;
    }

    private void guardar(Photos photos) {


            SQLiteDatabase Conexion = consumoApiConexion();

            ContentValues values = new ContentValues();
            Photos photo = new Photos();

            values.put(String.valueOf(photo.getId()), String.valueOf(photos.getId()));
            values.put(String.valueOf(photo.getAlbumId()), String.valueOf(photos.getAlbumId()));
            values.put(String.valueOf(photo.getId()), String.valueOf(photos.getId()));
            values.put(photo.getTitle(), photos.getTitle());
            values.put(photo.getUrl(), photos.getUrl());
            values.put(photo.getThumbnailUrl(), photos.getThumbnailUrl());

            Conexion.insert("photos", null, values);

            Toast.makeText(getApplicationContext(), "Se gurdaron los datos  " + photos.getId(), Toast.LENGTH_SHORT).show();
            Conexion.close();

    }






}



