package com.example.umusic.ui.Adapters;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.umusic.Models.DataTransfers.TrackData;
import com.example.umusic.R;
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
                               .inflate(R.layout.track_card, parent, false);


        return new ViewHolder(v);
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
        private TextView trackName;
        private TextView payloadCount;
        private ImageView pictureCard;

        public TrackData getTrack() {
            return track;
        }

        public void setTrack(TrackData track) {
            this.track = track;

            this.trackName.setText(track.name);
            this.payloadCount.setText(track.playcount); 
        }

        public ViewHolder(@NonNull View itemView) {
            super( itemView);
            trackName = itemView.findViewById(R.id.track_name);
            payloadCount = itemView.findViewById(R.id.track_playcount);
            pictureCard = itemView.findViewById(R.id.picture_card);

        }
    }
}
