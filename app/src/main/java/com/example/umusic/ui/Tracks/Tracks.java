package com.example.umusic.ui.Tracks;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.umusic.services.LastFMServices;
import com.example.umusic.Models.DataTransfers.TrackData;
import com.example.umusic.Models.Responses.TracksResponse;
import com.example.umusic.R;
import com.example.umusic.ui.Adapters.TracksAdapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Tracks extends Fragment {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private List<TrackData> trackList;
    private View loadingPanel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View fragment = inflater.inflate(R.layout.tracks_fragment, container, false);

        this.ConfigureRecycleView(fragment, R.id.tracks_view);
        this.RefreshDataSource(fragment);

        return fragment;
    }

    private void ConfigureRecycleView(View fragment, int fragmentId){
        recyclerView = fragment.findViewById(fragmentId);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    private void RefreshDataSource(View fragment)
    {
        loadingPanel = fragment.findViewById(R.id.loadingPanel);


        LastFMServices tracksController = LastFMServices.GetServiceInstance();
        Call<TracksResponse> data = tracksController.GetAllTopTracks();
        data.enqueue(new Callback<TracksResponse>() {
            @Override
            public void onResponse(Call<TracksResponse> call, Response<TracksResponse> response) {
                if (response.isSuccessful()) {
                    onDataLoaded(response.body().tracks.track);
                } else {
                    System.out.println(response.errorBody());
                }
                loadingPanel.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(Call<TracksResponse> call, Throwable t) {
                System.out.println(t.getMessage());
            }
        });
    }

    private void onDataLoaded(List<TrackData> tracks)
    {
        this.trackList = tracks;
        mAdapter = new TracksAdapter(this.trackList);
        recyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // TODO: Use the ViewModel
    }

}
