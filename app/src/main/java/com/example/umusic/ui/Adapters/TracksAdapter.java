package com.example.umusic.ui.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.umusic.Models.DataTransfers.TrackData;
import com.example.umusic.R;
import com.example.umusic.ui.Tracks.TrackCardFragment;

import java.util.List;

public class TracksAdapter extends RecyclerView.Adapter<TracksAdapter.ViewHolder> {

    private List<TrackData> tracks;

    public TracksAdapter(List<TrackData> tracks)
    {
        this.tracks = tracks;
    }

    @NonNull
    @Override
    public TracksAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        // create a new card view
        View v = LayoutInflater.from(parent.getContext())
                               .inflate(R.layout.fragment_track_card, parent, false);

        ViewHolder vh = new ViewHolder(v);

        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull TracksAdapter.ViewHolder holder, int position) {
        TrackData track = tracks.get(position);
        holder.setTrack(track);
    }

    @Override
    public int getItemCount() {
        return tracks != null ? tracks.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TrackData track;

        public TrackData getTrack() {
            return track;
        }

        public void setTrack(TrackData track) {
            this.track = track;
        }

        public ViewHolder(@NonNull TrackCardFragment itemView) {
            super(itemView);
        }
    }
}
