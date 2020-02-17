package com.example.umusic.services;

import com.example.umusic.Models.Responses.ArtistResponse;
import com.example.umusic.Models.Responses.TracksResponse;


import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.Call;

public interface LastFMApi {

    @GET("?method=chart.gettoptracks&format=json")
    Call<TracksResponse> getTopTracks(@Query("api_key") String api_key);

    @GET("?method=chart.gettopartists&format=json")
    Call<ArtistResponse> getTopArtist(@Query("api_key") String api_key);
}



