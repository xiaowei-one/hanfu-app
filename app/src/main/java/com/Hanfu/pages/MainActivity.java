package com.Hanfu.pages;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.Hanfu.R;
import com.Hanfu.adapter.IndexAdapter;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    TabLayout tabs;
    final String[] TAB_TITLES_icon = new String[]{"&#xe6b6;", "&#xe649;", "&#xe682;", "&#xe620;"};
    final int[] TAB_TITLES = new int[]{R.string.index, R.string.party, R.string.shopping, R.string.person};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IndexAdapter indexAdapter = new IndexAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager_index);
        viewPager.setAdapter(indexAdapter);
        TabLayout tabs = findViewById(R.id.tabs_index);
        setCustomIcon();
        tabs.setupWithViewPager(viewPager);
    }

    /**
     * 设置自定义位置图标
     */
    private void setCustomIcon() {
        for (int i = 0; i < TAB_TITLES.length; i++) {
            tabs.addTab(tabs.newTab());
        }
        for (int i = 0; i < TAB_TITLES.length; i++) {
            tabs.getTabAt(i).setCustomView(makeTabView(i));
        }
    }

    /**
     * 引入布局设置图标和标题
     *
     * @param position
     * @return
     */
    private View makeTabView(int position) {
        View tabView = LayoutInflater.from(this).inflate(R.layout.index_tab_bar, null);
        TextView tab_icon = tabView.findViewById(R.id.tab_icon);
        TextView tab_text = tabView.findViewById(R.id.tab_text);
        tab_text.setText(TAB_TITLES[position]);
        tab_icon.setText(TAB_TITLES_icon[position]);
        return tabView;
    }
}