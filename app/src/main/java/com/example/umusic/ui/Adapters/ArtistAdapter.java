package com.example.umusic.ui.Adapters;

import com.example.umusic.Models.DataTransfers.ArtistData;
import com.example.umusic.Models.DataTransfers.TrackData;

import java.util.List;

public class ArtistAdapter extends BaseAdapter<ArtistData> {


    public ArtistAdapter(List<ArtistData> dataSource) {
        super(dataSource);
    }

    @Override
    public void setDataToViewHolder(BaseAdapter.ViewHolder viewHolder, ArtistData item)
    {
        viewHolder.cardTitle.setText(item.name);
        viewHolder.cardSubTitle.setText(item.playcount);
    }
}
