package com.Hanfu.pages;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import com.Hanfu.R;
import com.Hanfu.fragment.CommoditySearchFragment;
import com.Hanfu.fragment.PageSearchFragment;
import com.Hanfu.fragment.PartySearchFragment;
import com.Hanfu.utils.StatusBarUtil;

public class SearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

//      根据状态栏颜色来决定状态栏文字用黑色还是白色
        StatusBarUtil.setStatusBarMode(this, true, R.color.white);

        String type = getIntent().getStringExtra("type");
        FragmentManager fragmentManager = getSupportFragmentManager();

        switch (type) {
            case "page":
                fragmentManager.beginTransaction()
                        .replace(R.id.search, new PageSearchFragment())
                        .commit();
                break;
            case "party":
                fragmentManager.beginTransaction()
                        .replace(R.id.search, new PartySearchFragment())
                        .commit();
                break;
            case "shopping":
                fragmentManager.beginTransaction()
                        .replace(R.id.search, new CommoditySearchFragment())
                        .commit();
                break;
        }
    }
}