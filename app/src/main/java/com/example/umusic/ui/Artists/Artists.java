package com.example.umusic.ui.Artists;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.umusic.Models.DataTransfers.ArtistData;
import com.example.umusic.Models.Responses.ArtistsResponse;
import com.example.umusic.R;
import com.example.umusic.services.LastFMServices;
import com.example.umusic.ui.Adapters.ArtistAdapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Artists extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private List<ArtistData> artistList;
    private View loadingPanel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View fragment = inflater.inflate(R.layout.artists_fragment, container, false);

        this.ConfigureRecycleView(fragment, R.id.artists_view);
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


        LastFMServices lastFMServices = LastFMServices.GetServiceInstance();
        Call<ArtistsResponse> data = lastFMServices.GetAllTopArtists();
        data.enqueue(new Callback<ArtistsResponse>() {
            @Override
            public void onResponse(Call<ArtistsResponse> call, Response<ArtistsResponse> response) {
                if (response.isSuccessful()) {
                    onDataLoaded(response.body().artists.artist);
                } else {
                    System.out.println(response.errorBody());
                }
                loadingPanel.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(Call<ArtistsResponse> call, Throwable t) {
                System.out.println(t.getMessage());
            }
        });
    }

    private void onDataLoaded(List<ArtistData> artists)
    {
        this.artistList = artists;
        mAdapter = new ArtistAdapter(this.artistList);
        recyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // TODO: Use the ViewModel
    }

}
