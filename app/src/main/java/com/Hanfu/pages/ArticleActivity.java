package com.Hanfu.pages;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import com.Hanfu.R;
import com.Hanfu.fragment.LongVideoFragment;
import com.Hanfu.fragment.ShortVideoFragment;
import com.Hanfu.fragment.TextFragment;

public class ArticleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article);

        FragmentManager fragmentManager = getSupportFragmentManager();
        Intent intent = getIntent();
        String type = intent.getStringExtra("articleType");
        Log.i("type", type);
        if (type.equals("text")) {
            fragmentManager
                    .beginTransaction()
                    .replace(R.id.article, new TextFragment())
                    .commit();
        } else if (type.equals("shortVideo")) {
            fragmentManager
                    .beginTransaction()
                    .replace(R.id.article, new ShortVideoFragment())
                    .commit();
        } else if (type.equals("longVideo")) {
            fragmentManager
                    .beginTransaction()
                    .replace(R.id.article, new LongVideoFragment())
                    .commit();
        }
    }
}