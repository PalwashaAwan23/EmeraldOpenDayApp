package com.example.emeraldopendayapp;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AiRetrofitClient {
    private static Retrofit retrofit;

    public static Retrofit getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl("http://10.0.2.2:8000/")  // <-- Your FastAPI port
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
