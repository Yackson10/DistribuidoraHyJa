package com.example.distribuidorahyj.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.distribuidorahyj.Interface.JsonplaceholderApi;
import com.example.distribuidorahyj.Interface.ServiceApi;
import com.example.distribuidorahyj.R;
import com.example.distribuidorahyj.adaptadores.AdapterPhotos;
import com.example.distribuidorahyj.domain.Photos;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ConsumoApi extends AppCompatActivity {

    TextView albumId, id, title, url, thumbnailUrl;
    RecyclerView recyclerView;
    AdapterPhotos adapter;
    ArrayList<Photos> listPhotos = new ArrayList<>();
    ArrayList<Photos> listPhotosDB = new ArrayList<>();
    ProgressBar progressBar;
    private EditText buscarApiId;
    JsonplaceholderApi json;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consumo_api);
        albumId = findViewById(R.id.album);
        id = findViewById(R.id.id);
        title = findViewById(R.id.titulo);
        url = findViewById(R.id.url);
        thumbnailUrl = findViewById(R.id.thum);

        buscarApiId = findViewById(R.id.textBuscarApi);
        recyclerView = findViewById(R.id.recyclerView);

        progressBar = findViewById(R.id.progressBar);
        progressBar.setMax(10);

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

                    adapter.setItems(listPhotos);
                    for (Photos list : listPhotos
                    ) {
                        //guardar(list);
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Photos>> call, Throwable t) {
            }
        });
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

}

    /*public SQLiteDatabase consumoApi() {

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
        SQLiteDatabase baseDeDatos = admin.getWritableDatabase();
        return baseDeDatos;
    }*/

    /*public void progressBar() {
        progressBar.setMax(10);
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter = 1;
                progressBar.setVisibility(View.VISIBLE);
                progressBar.setProgress(0);
                switch (v.getId()){
                    case R.id.btnBuscarApi;
                        new MySd

                }

            }
        };

    }*/

    /*private void guardar(Photos photos) {

        try {
            SQLiteDatabase oConexion = consumoApi();

            ContentValues values = new ContentValues();
            Photos photo = new Photos();

            values.put(String.valueOf(photo.getId()), String.valueOf(photos.getId()));
            values.put(String.valueOf(photo.getAlbumId()), String.valueOf(photos.getAlbumId()));
            values.put(String.valueOf(photo.getId()), String.valueOf(photos.getId()));
            values.put(photo.getTitle(), photos.getTitle());
            values.put(photo.getUrl(), photos.getUrl());
            values.put(photo.getThumbnailUrl(), photos.getThumbnailUrl());

            long idResultado = oConexion.insert("photo", null, values);

            Toast.makeText(getApplicationContext(), "Se gurdaron los datos  " + photos.getId(), Toast.LENGTH_SHORT).show();
            oConexion.close();

        }catch(OutOfMemoryError e){
            e.printStackTrace();
        }
    }*/



    /*@RequiresApi(api = Build.VERSION_CODES.N)
    public Photos buscarApiLambda(String id){

        String id = buscarApiId.getText().toString();


        //List<Photos> lista =listPhotos
          //      Stream stream = lista.stream()
            //            .map()

        /*return listPhotos.stream()
                .filter(photos -> photos.getId().equa(id))
                .map(photos -> photos.toString())
                .collect(Collectors.joining(","));
    } */
            /*if (!id.isEmpty()) {

                //Photos photos = new Photos();
                //photos.setId(Integer.parseInt(id));
                //photos.setAlbumId((photos.getAlbumId()));
                //listPhotos.add(photos);

            }else {

            }*/
//}


