package com.Hanfu.adapter;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.Hanfu.R;
import com.Hanfu.fragment.IndexFragment;
import com.Hanfu.fragment.PartyFragment;
import com.Hanfu.fragment.PersonFragment;
import com.Hanfu.fragment.ShoppingFragment;
import com.Hanfu.pages.ui.index.RecommendFragment;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class IndexAdapter extends FragmentPagerAdapter {

    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.index, R.string.party, R.string.shopping, R.string.person};
    private final Context mContext;

    public IndexAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        if(position == 0){
            return IndexFragment.newInstance(position + 1);
        } else if (position == 1){
            return PartyFragment.newInstance("2","2");
        } else if (position == 2){
            return ShoppingFragment.newInstance("3","3");
        } else {
            return PersonFragment.newInstance("4","4");
        }
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public int getCount() {
        return 4;
    }
}
