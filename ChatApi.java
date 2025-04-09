package com.example.emeraldopendayapp;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ChatApi {
    @Headers("Content-Type: application/json")
    @POST("/chat")
    Call<ChatResponse> sendQuestion(@Body ChatRequest request);
}
