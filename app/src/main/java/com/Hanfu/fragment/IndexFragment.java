package com.Hanfu.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.Hanfu.R;
import com.Hanfu.pages.ui.index.RecommendAdapter;
import com.google.android.material.tabs.TabLayout;

/**
 * A placeholder fragment containing a simple view.
 */
public class IndexFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";


    public static IndexFragment newInstance(int index) {
        IndexFragment fragment = new IndexFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_SECTION_NUMBER, index);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_index, container, false);
        RecommendAdapter recommendAdapter = new RecommendAdapter(getContext(), getChildFragmentManager());
        ViewPager viewPager = view.findViewById(R.id.view_pager);
        viewPager.setAdapter(recommendAdapter);
        TabLayout tabs = view.findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
        return view;
    }
}
