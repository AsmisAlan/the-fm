package com.example.umusic.ui.Tracks;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.umusic.Controller.LastFMApiController;
import com.example.umusic.Models.DataTransfers.TrackData;
import com.example.umusic.Models.Responses.TracksResponse;
import com.example.umusic.R;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

public class Tracks extends Fragment {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;


    private TracksViewModel mViewModel;
    private List<TrackData> trackList;

    public static Tracks newInstance() {
        return new Tracks();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View fragment = inflater.inflate(R.layout.tracks_fragment, container, false);

        recyclerView = (RecyclerView) fragment.findViewById(R.id.tracks_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


        LastFMApiController tracksController = new LastFMApiController();

        try {
            Response<TracksResponse> data = tracksController.GetAll().execute();
            this.OnDataLoaded(data.body().tracks.track);
        } catch (IOException e) {
            e.printStackTrace();
        }


        return fragment;
    }

    public void OnDataLoaded(List<TrackData> tracks)
    {

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(TracksViewModel.class);
        // TODO: Use the ViewModel
    }

}
