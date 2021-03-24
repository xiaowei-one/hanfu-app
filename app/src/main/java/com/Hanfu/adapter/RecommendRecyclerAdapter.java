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
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityCompat;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.util.Pair;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.Hanfu.R;
import com.Hanfu.pages.ArticleActivity;
import com.Hanfu.pages.MainActivity;

import java.util.List;
import java.util.Random;

public class RecommendRecyclerAdapter extends RecyclerView.Adapter<RecommendRecyclerAdapter.ViewHolder> {
    List mList;
    Context context;
    String mDrawableName;
    int randomNum;

    public RecommendRecyclerAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public RecommendRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
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
            randomNum = Numbers[random.nextInt(9)];
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
    public void onBindViewHolder(@NonNull RecommendRecyclerAdapter.ViewHolder holder, int position) {
        Intent intent = new Intent(context, ArticleActivity.class);
        intent.putExtra("articleType", "text");
        if (position < 1 || (position > 1 && randomNum == 0)) {
            TextView article_text_text = holder.itemView.findViewById(R.id.article_text_text);
            article_text_text.setOnClickListener(v -> {
                intent.putExtra("articleType", "text");
                context.startActivity(intent);
            });
        } else if (position != 1) {
            LinearLayout article_long_video = holder.itemView.findViewById(R.id.article_long_video);
            article_long_video.setOnClickListener(v -> {
                intent.putExtra("articleType", "longVideo");
                context.startActivity(intent);
            });
        }
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