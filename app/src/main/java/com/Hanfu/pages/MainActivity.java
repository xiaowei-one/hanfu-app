package com.Hanfu.pages;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

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
    }
}