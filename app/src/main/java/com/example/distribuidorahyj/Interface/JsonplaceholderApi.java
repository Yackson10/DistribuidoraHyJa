package com.example.distribuidorahyj.Interface;

import com.example.distribuidorahyj.domain.Photos;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonplaceholderApi {

        @GET("Photos")
        Call<List<Photos>> getPhotos();

}
