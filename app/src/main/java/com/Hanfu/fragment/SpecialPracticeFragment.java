package com.Hanfu.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.Hanfu.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SpecialPracticeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SpecialPracticeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SpecialPracticeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SpecialFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SpecialPracticeFragment newInstance(String param1, String param2) {
        SpecialPracticeFragment fragment = new SpecialPracticeFragment();
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
        View view = inflater.inflate(R.layout.fragment_special_practice, container, false);
        TextView back_title = view.findViewById(R.id.back_title);
        back_title.setText("专项练习");
        TextView article_text_back = view.findViewById(R.id.article_text_back);
        article_text_back.setOnClickListener(v -> {
            getActivity().finish();
        });

        Button start_answer = view.findViewById(R.id.start_answer);
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();

        start_answer.setOnClickListener(v -> {
            fragmentManager.beginTransaction()
                    .replace(R.id.practice, new RandomPracticeFragment())
                    .commit();
        });

        return view;
    }
}