package com.Hanfu.pages;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.Hanfu.R;
import com.Hanfu.fragment.LongVideoFragment;
import com.Hanfu.fragment.ShortVideoFragment;
import com.Hanfu.fragment.TextFragment;
import com.Hanfu.utils.StatusBarUtil;

public class ArticleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article);

//      根据状态栏颜色来决定状态栏文字用黑色还是白色
        StatusBarUtil.setStatusBarMode(this, true, R.color.white);

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