package com.example.umusic.Models.Responses;

import com.example.umusic.Models.DataTransfers.ArtistData;

import java.util.List;

public class ArtistResponse {
    public List<ArtistData> artist;

    public List<ArtistData> getArtist() {
        return artist;
    }

    public void setArtist(List<ArtistData> artist) {
        this.artist = artist;
    }
}
