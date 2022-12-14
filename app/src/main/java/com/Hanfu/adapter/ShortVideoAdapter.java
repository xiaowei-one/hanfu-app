package com.Hanfu.adapter;


import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.Hanfu.R;
import com.Hanfu.pages.ArticleActivity;

import java.util.List;

public class ShortVideoAdapter extends RecyclerView.Adapter<ShortVideoAdapter.ViewHolder> {
    List mList;
    Context context;
    String mDrawableName;

    public ShortVideoAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.index_short_video_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Intent intent = new Intent(context, ArticleActivity.class);
        holder.itemView.setOnClickListener(v -> {
            intent.putExtra("articleType", "shortVideo");
            context.startActivity(intent);
        });

    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return 10;
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