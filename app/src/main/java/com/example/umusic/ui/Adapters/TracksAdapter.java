package com.example.umusic.ui.Adapters;


import com.example.umusic.Models.BaseAdapterItem;
import com.example.umusic.Models.DataTransfers.TrackData;

import java.util.List;

public class TracksAdapter extends BaseAdapter<TrackData> {


    public TracksAdapter(List<TrackData> dataSource) {
        super(dataSource);
    }

    @Override
    public void  setDataToViewHolder(BaseAdapter.ViewHolder viewHolder, TrackData item)
    {
        viewHolder.cardTitle.setText(item.name);
        viewHolder.cardSubTitle.setText(item.playcount);
    }
}
