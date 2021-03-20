package com.Hanfu.adapter;


import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.Hanfu.R;

import java.util.List;
import java.util.Random;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    List mList;
    Context context;
    String mDrawableName;

    public RecyclerAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = null;
        Random random = new Random();
        if (viewType < 1) {
            itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.index_text, parent, false);
        } else if (viewType == 1) {
            itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.index_short_video, parent, false);
            RecyclerView recyclerView = itemView.findViewById(R.id.shortVideo);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, RecyclerView.HORIZONTAL, false);
            recyclerView.setLayoutManager(linearLayoutManager);
            ShortVideoAdapter shortVideoAdapter = new ShortVideoAdapter(context);
            recyclerView.setAdapter(shortVideoAdapter);
        } else if (viewType > 1) {
            int[] Numbers = {0, 0, 1, 0, 1, 0, 0, 0, 1};
            int randomNum = Numbers[random.nextInt(9)];
            if (randomNum == 1) {
                itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.index_long_video, parent, false);
            } else {
                itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.index_text, parent, false);
            }
        }
        ViewHolder viewHolder = new ViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.ViewHolder holder, int position) {

        holder.itemView.setOnClickListener(v -> {

        });

    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return 40;
    }

    @Nullable
    public static Activity findActivity(Context context) {
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            ContextWrapper wrapper = (ContextWrapper) context;
            return findActivity(wrapper.getBaseContext());
        } else {
            return null;
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView stoneName;
        ImageView handImage1;
        TextView handDescription;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}