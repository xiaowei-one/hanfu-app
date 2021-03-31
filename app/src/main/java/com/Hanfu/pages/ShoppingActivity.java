package com.Hanfu.pages;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;

import com.Hanfu.R;
import com.Hanfu.fragment.CommodityDetailFragment;
import com.Hanfu.fragment.MyOrdersFragment;
import com.Hanfu.utils.StatusBarUtil;

public class ShoppingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping);

        //      根据状态栏颜色来决定状态栏文字用黑色还是白色
        StatusBarUtil.setStatusBarMode(this, true, R.color.white);

        FragmentManager fragmentManager = getSupportFragmentManager();
        String type = getIntent().getStringExtra("type");
        if(type.equals("commodityDetail")){
            fragmentManager.beginTransaction()
                    .replace(R.id.shopping_root, new CommodityDetailFragment())
                    .commit();
        }
        else if(type.equals("myOrders")){
            fragmentManager.beginTransaction()
                    .replace(R.id.shopping_root, new MyOrdersFragment())
                    .commit();
        }
    }
}