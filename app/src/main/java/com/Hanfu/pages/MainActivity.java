package com.Hanfu.pages;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.Hanfu.R;
import com.Hanfu.adapter.IndexAdapter;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IndexAdapter indexAdapter = new IndexAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager_index);
        viewPager.setAdapter(indexAdapter);
        TabLayout tabs = findViewById(R.id.tabs_index);
        tabs.setupWithViewPager(viewPager);
        tabs.getTabAt(0).setIcon(R.mipmap.index);
        tabs.getTabAt(1).setIcon(R.mipmap.party);
        tabs.getTabAt(2).setIcon(R.mipmap.shoping);
        tabs.getTabAt(3).setIcon(R.mipmap.person);
    }
}