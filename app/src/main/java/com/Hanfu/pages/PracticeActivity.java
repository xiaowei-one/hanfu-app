package com.Hanfu.pages;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import com.Hanfu.R;
import com.Hanfu.fragment.QuestionsRankFragment;
import com.Hanfu.fragment.RandomPracticeFragment;
import com.Hanfu.fragment.SingleCompetitionFragment;
import com.Hanfu.fragment.SoloCompetitionFragment;
import com.Hanfu.fragment.SpecialPracticeFragment;
import com.Hanfu.fragment.WrongQuestionsFragment;
import com.Hanfu.utils.StatusBarUtil;

public class PracticeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pratice);
//      根据状态栏颜色来决定状态栏文字用黑色还是白色
        StatusBarUtil.setStatusBarMode(this, true, R.color.white);
        String type = getIntent().getStringExtra("type");
        FragmentManager fragmentManager = getSupportFragmentManager();
        switch(type){
            case "special_practice":
                fragmentManager.beginTransaction()
                        .replace(R.id.practice, new SpecialPracticeFragment())
                        .commit();
                break;
            case "wrong_questions":
                fragmentManager.beginTransaction()
                        .replace(R.id.practice, new WrongQuestionsFragment())
                        .commit();
                break;
            case "random_practice":
                fragmentManager.beginTransaction()
                        .replace(R.id.practice, new RandomPracticeFragment())
                        .commit();
                break;
            case "solo":
                fragmentManager.beginTransaction()
                        .replace(R.id.practice, new SoloCompetitionFragment())
                        .commit();
                break;
            case "single":
                fragmentManager.beginTransaction()
                        .replace(R.id.practice, new SingleCompetitionFragment())
                        .commit();
                break;
            case "rank":
                fragmentManager.beginTransaction()
                        .replace(R.id.practice, new QuestionsRankFragment())
                        .commit();
                break;
        }

    }
}