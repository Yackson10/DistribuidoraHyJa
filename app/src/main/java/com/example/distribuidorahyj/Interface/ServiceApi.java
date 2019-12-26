package com.example.distribuidorahyj.Interface;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

// sdsa
public class ServiceApi {

    private static JsonplaceholderApi  retrofit;

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
