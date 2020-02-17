package com.example.umusic.Models.Responses;

public class ArtistsResponse {
    public ArtistResponse Artists;

    public ArtistResponse getArtist() {
        return Artists;
    }

    public void setArtist(ArtistResponse artist) {
        Artists = artist;
    }
}
