package com.example.distribuidorahyj;

import com.example.distribuidorahyj.Interface.JsonplaceholderApi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceApi {

    private static JsonplaceholderApi retrofit;

    public static  JsonplaceholderApi getRetrofit() {

        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl("https://jsonplaceholder.typicode.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build().create(JsonplaceholderApi.class);
        }
        return retrofit;

    }
}
