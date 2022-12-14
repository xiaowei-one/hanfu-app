package com.Hanfu.fragment;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.Hanfu.R;
import com.Hanfu.pages.PracticeActivity;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CompetitionFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CompetitionFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CompetitionFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CompetitionFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CompetitionFragment newInstance(String param1, String param2) {
        CompetitionFragment fragment = new CompetitionFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_competition, container, false);

//        ??????title
        TextView back_title = view.findViewById(R.id.back_title);
        back_title.setText("????????????");

//        ???????????????????????????
        FrameLayout score = view.findViewById(R.id.score);
        FrameLayout practice = view.findViewById(R.id.practice);

        Animation animation = AnimationUtils.loadAnimation(getContext(), R.anim.scale);

        score.setAnimation(animation);
        practice.setAnimation(animation);


//      ?????????????????????
        TextView article_text_back = view.findViewById(R.id.article_text_back);
        article_text_back.setOnClickListener(v -> {
            getActivity().finish();
        });

        Intent intent = new Intent(getContext(), PracticeActivity.class);

//      ??????????????????
        LinearLayout special_exercises = view.findViewById(R.id.special_practice);
        special_exercises.setOnClickListener(v -> {
            intent.putExtra("type", "special_practice");
            startActivity(intent);
        });
//        ???????????????
        LinearLayout wrong_questions = view.findViewById(R.id.wrong_questions);
        wrong_questions.setOnClickListener(v -> {
            intent.putExtra("type", "wrong_questions");
            startActivity(intent);
        });
//        ??????????????????
        LinearLayout random_practice = view.findViewById(R.id.random_practice);
        random_practice.setOnClickListener(v -> {
            intent.putExtra("type", "random_practice");
            startActivity(intent);
        });
//        ??????PK?????????
        LinearLayout solo = view.findViewById(R.id.solo);
        solo.setOnClickListener(v -> {
            intent.putExtra("type", "solo");
            startActivity(intent);
        });
//        ?????????????????????
        LinearLayout single = view.findViewById(R.id.single);
        single.setOnClickListener(v -> {
            intent.putExtra("type", "single");
            startActivity(intent);
        });
//        ???????????????
        LinearLayout rank = view.findViewById(R.id.rank);
        rank.setOnClickListener(v -> {
            intent.putExtra("type", "rank");
            startActivity(intent);
        });

        return view;
    }
}