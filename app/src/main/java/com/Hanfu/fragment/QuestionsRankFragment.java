package com.Hanfu.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.Hanfu.R;
import com.Hanfu.adapter.QuestionsRankAdapter;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link QuestionsRankFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class QuestionsRankFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public QuestionsRankFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment QuestionsRankFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static QuestionsRankFragment newInstance(String param1, String param2) {
        QuestionsRankFragment fragment = new QuestionsRankFragment();
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
        View view = inflater.inflate(R.layout.fragment_questions_rank, container, false);
        TextView back_title = view.findViewById(R.id.back_title);
        back_title.setText("答题排行榜");
        TextView article_text_back = view.findViewById(R.id.article_text_back);
        article_text_back.setOnClickListener(v -> {
            getActivity().finish();
        });

        RecyclerView questions_rank_recycler = view.findViewById(R.id.questions_rank_recycler);
        QuestionsRankAdapter questionsRankAdapter = new QuestionsRankAdapter(getContext());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        questions_rank_recycler.setAdapter(questionsRankAdapter);
        questions_rank_recycler.setLayoutManager(linearLayoutManager);

        return view;
    }
}