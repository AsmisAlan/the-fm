package com.example.umusic.services;

import com.example.umusic.Models.Responses.ArtistResponse;
import com.example.umusic.Models.Responses.TracksResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LastFMServices {

    static final String BASE_URL = "http://ws.audioscrobbler.com/2.0/";
    static final String API_KEY = "4e61bdef6472e3ec9037bef0fab423f5";
    private LastFMApi api;

    private static LastFMServices service;

    public static LastFMServices GetServiceInstance()
    {
        service = service != null ? service : new LastFMServices();

        return service;
    }


    private LastFMServices()
    {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

         api = retrofit.create(LastFMApi.class);
    }

    public Call<TracksResponse> GetAllTopTracks()
    {
        Call<TracksResponse> call = api.getTopTracks(API_KEY);
        return call;
    }

    public Call<ArtistResponse> GetAllTopArtists()
    {
        Call<ArtistResponse> call = api.getTopArtist(API_KEY);
        return call;
    }
}
