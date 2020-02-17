package com.example.umusic.Models.Responses;


import com.example.umusic.Models.DataTransfers.TrackData;

import java.util.List;

public class TrackResponse {

    public List<TrackData> track;

    public List<TrackData> getTrack() {
        return track;
    }

    public void setTrack(List<TrackData> track) {
        this.track = track;
    }
}
