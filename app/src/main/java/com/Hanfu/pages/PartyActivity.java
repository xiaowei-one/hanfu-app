package com.Hanfu.pages;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import com.Hanfu.R;
import com.Hanfu.fragment.CompetitionFragment;
import com.Hanfu.fragment.PartyRankFragment;
import com.Hanfu.utils.StatusBarUtil;

public class PartyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_party);

//      根据状态栏颜色来决定状态栏文字用黑色还是白色
        StatusBarUtil.setStatusBarMode(this, true, R.color.white);

        String type = getIntent().getStringExtra("type");
        FragmentManager fragmentManager = getSupportFragmentManager();

        if(type.equals("offline_party")){
            fragmentManager.beginTransaction()
                    .replace(R.id.party, new PartyRankFragment())
                    .commit();
        } else if(type.equals("online_competition")){
            fragmentManager.beginTransaction()
                    .replace(R.id.party, new CompetitionFragment())
                    .commit();
        }
    }
}