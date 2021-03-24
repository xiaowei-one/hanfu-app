package com.Hanfu.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.Hanfu.R;
import com.Hanfu.adapter.PartyRankAdapter;
import com.Hanfu.adapter.ShortVideoAdapter;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PartyRankFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PartyRankFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public PartyRankFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PartyRankFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PartyRankFragment newInstance(String param1, String param2) {
        PartyRankFragment fragment = new PartyRankFragment();
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
        View view = inflater.inflate(R.layout.fragment_party_rank, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.party_rank_list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        PartyRankAdapter partyRankAdapter = new PartyRankAdapter(getContext());
        recyclerView.setAdapter(partyRankAdapter);

        return view;
    }
}