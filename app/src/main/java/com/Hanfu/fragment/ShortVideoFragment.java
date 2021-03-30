package com.Hanfu.fragment;

import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.Hanfu.R;

import static com.Hanfu.utils.Utils.commentAnimate;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ShortVideoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ShortVideoFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ShortVideoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ShortVideoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ShortVideoFragment newInstance(String param1, String param2) {
        ShortVideoFragment fragment = new ShortVideoFragment();
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
        View view = inflater.inflate(R.layout.fragment_short_video, container, false);

        LinearLayout article_root = view.findViewById(R.id.short_video_root);
        FrameLayout article_page = view.findViewById(R.id.short_video_page);
        EditText text_comment = view.findViewById(R.id.text_comment);
        LinearLayout comment_icon = view.findViewById(R.id.comment_icon);
        CardView send_comment = view.findViewById(R.id.send_comment);
        TextView article_short_video_back = view.findViewById(R.id.article_short_video_back);

        article_page.setOnClickListener(v -> {
            text_comment.clearFocus();
        });

        article_root.setOnClickListener(v -> {
            text_comment.clearFocus();
        });

        article_short_video_back.setOnClickListener(v->{
            getActivity().finish();
        });

        commentAnimate(getActivity(), getContext(), text_comment, comment_icon, send_comment);
        return view;
    }
}