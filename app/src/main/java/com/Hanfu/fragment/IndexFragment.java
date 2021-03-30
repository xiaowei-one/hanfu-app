package com.Hanfu.fragment;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.viewpager.widget.ViewPager;

import com.Hanfu.R;
import com.Hanfu.domain.IconPowerMenuItem;
import com.Hanfu.pages.SearchActivity;
import com.Hanfu.pages.ui.index.RecommendAdapter;
import com.Hanfu.utils.IconMenuAdapter;
import com.Hanfu.utils.PowerMenuUtils;
import com.google.android.material.tabs.TabLayout;
import com.skydoves.powermenu.CustomPowerMenu;
import com.skydoves.powermenu.MenuAnimation;
import com.skydoves.powermenu.OnMenuItemClickListener;
import com.skydoves.powermenu.PowerMenu;
import com.skydoves.powermenu.PowerMenuItem;

import java.util.List;

import static com.Hanfu.utils.Utils.px2dip;

/**
 * A placeholder fragment containing a simple view.
 */
public class IndexFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";

    private CustomPowerMenu customPowerMenu;

    public static IndexFragment newInstance(int index) {
        IndexFragment fragment = new IndexFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_SECTION_NUMBER, index);
        fragment.setArguments(bundle);
        return fragment;
    }

    private final OnMenuItemClickListener<IconPowerMenuItem> onIconMenuItemClickListener = (position, item) -> {
        Toast.makeText(getContext(), item.getTitle(), Toast.LENGTH_SHORT).show();
        customPowerMenu.dismiss();
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_index, container, false);

        //选择查询条件部分
        customPowerMenu = new CustomPowerMenu.Builder<>(getContext(), new IconMenuAdapter())
                .addItem(new IconPowerMenuItem(ContextCompat.getDrawable(getContext(), R.mipmap.add_text), "写文章"))
                .addItem(new IconPowerMenuItem(ContextCompat.getDrawable(getContext(), R.mipmap.add_video1), "发视频"))
                .addItem(new IconPowerMenuItem(ContextCompat.getDrawable(getContext(), R.mipmap.drafts), "草稿箱"))
                .setOnMenuItemClickListener(onIconMenuItemClickListener)
                .setAnimation(MenuAnimation.SHOWUP_TOP_RIGHT)
                .setWidth(400)
                .setMenuRadius(10f)
                .setMenuShadow(10f)
                .setPadding(px2dip(getContext(), 60))
                .build();

        TextView add_page = view.findViewById(R.id.add_page);
        add_page.setOnClickListener(v -> {
            onCustom(v);
        });

        TextView search_page = view.findViewById(R.id.search_page);
        search_page.setOnClickListener(v->{
            Intent intent_search = new Intent(getContext(), SearchActivity.class);
            intent_search.putExtra("type", "page");
            startActivity(intent_search);
        });

//        文章列表
        RecommendAdapter recommendAdapter = new RecommendAdapter(getContext(), getChildFragmentManager());
        ViewPager viewPager = view.findViewById(R.id.view_pager);
        viewPager.setAdapter(recommendAdapter);
        TabLayout tabs = view.findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
        return view;
    }

    //选择查询条件部分
    public void onCustom(View view) {
        if (customPowerMenu.isShowing()) {
            customPowerMenu.dismiss();
            return;
        }
        customPowerMenu.showAsDropDown(view);
    }

}
