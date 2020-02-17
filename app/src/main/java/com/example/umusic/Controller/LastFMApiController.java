package com.example.umusic.Controller;

import com.example.umusic.Models.Responses.TracksResponse;
import com.example.umusic.services.LastFMApi;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LastFMApiController implements Callback<TracksResponse>  {

    static final String BASE_URL = "http://ws.audioscrobbler.com/2.0/";
    static final String API_KEY = "4e61bdef6472e3ec9037bef0fab423f5";

    public void GetAll()
    {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        LastFMApi gerritAPI = retrofit.create(LastFMApi.class);


        Call<TracksResponse> call = gerritAPI.getTopTracks(API_KEY);
        call.enqueue(this);
    }

    @Override
    public void onResponse(Call<TracksResponse> call, Response<TracksResponse> response) {
        if (response.isSuccessful()) {
             System.out.println("Response: ");
             System.out.println(response.body());
        } else {
            System.out.println(response.errorBody());
        }
    }

    @Override
    public void onFailure(Call<TracksResponse> call, Throwable t) {
        System.out.println(t.getMessage());
    }
}
