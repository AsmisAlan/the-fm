package com.example.umusic.ui.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.umusic.R;

import java.util.List;

public class BaseAdapter<T> extends RecyclerView.Adapter<BaseAdapter<T>.ViewHolder<T>> {

    private List<T> dataSource;

    public BaseAdapter(List<T> dataSource)
    {
        this.dataSource = dataSource;
    }

    @NonNull
    @Override
    public ViewHolder<T> onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        // create a new card view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.generic_card, parent, false);

        return new ViewHolder<T>(v);
    }

    @Override
    public void onBindViewHolder(@NonNull BaseAdapter.ViewHolder holder, int position) {
        T item = dataSource.get(position);
        setDataToViewHolder(holder, item);
    }

    public void setDataToViewHolder(BaseAdapter.ViewHolder viewHolder, T itemData) { }

    @Override
    public int getItemCount() {
        return dataSource != null ? dataSource.size() : 0;
    }

    public class ViewHolder<T> extends RecyclerView.ViewHolder {

        public TextView cardTitle;
        public TextView cardSubTitle;
        public ImageView cardPicture;


        public ViewHolder(@NonNull View itemView) {
            super( itemView);
            cardTitle = itemView.findViewById(R.id.generic_card_title);
            cardSubTitle = itemView.findViewById(R.id.generic_card_payload);
            cardPicture = itemView.findViewById(R.id.picture_card);
        }
    }
}