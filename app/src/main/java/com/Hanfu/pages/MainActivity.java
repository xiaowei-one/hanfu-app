package com.Hanfu.pages;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.Hanfu.R;
import com.Hanfu.adapter.IndexAdapter;
import com.Hanfu.utils.StatusBarUtil;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//      根据状态栏颜色来决定状态栏文字用黑色还是白色
        StatusBarUtil.setStatusBarMode(this, true, R.color.white);

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