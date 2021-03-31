package com.Hanfu.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.Hanfu.R;
import com.Hanfu.adapter.ShoppingListsAdapter;
import com.Hanfu.domain.IconPowerMenuItem;
import com.Hanfu.pages.SearchActivity;
import com.Hanfu.pages.ShoppingActivity;
import com.Hanfu.utils.IconMenuAdapter;
import com.skydoves.powermenu.CustomPowerMenu;
import com.skydoves.powermenu.MenuAnimation;
import com.skydoves.powermenu.OnMenuItemClickListener;

import static com.Hanfu.utils.Utils.px2dip;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ShoppingFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ShoppingFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private CustomPowerMenu customPowerMenu;

    private final OnMenuItemClickListener<IconPowerMenuItem> onIconMenuItemClickListener = (position, item) -> {
        Intent intent = new Intent(getContext(), ShoppingActivity.class);
        if(position == 3){
            intent.putExtra("type", "myOrders");
            startActivity(intent);
        }
        customPowerMenu.dismiss();
    };

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ShoppingFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ShoppingFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ShoppingFragment newInstance(String param1, String param2) {
        ShoppingFragment fragment = new ShoppingFragment();
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
        View view = inflater.inflate(R.layout.fragment_shopping, container, false);

        //选择查询条件部分
        customPowerMenu = new CustomPowerMenu.Builder<>(getContext(), new IconMenuAdapter())
                .addItem(new IconPowerMenuItem(ContextCompat.getDrawable(getContext(), R.mipmap.add_text), "出售商品"))
                .addItem(new IconPowerMenuItem(ContextCompat.getDrawable(getContext(), R.mipmap.add_text), "我的出售"))
                .addItem(new IconPowerMenuItem(ContextCompat.getDrawable(getContext(), R.mipmap.add_video1), "我的收藏"))
                .addItem(new IconPowerMenuItem(ContextCompat.getDrawable(getContext(), R.mipmap.drafts), "我的订单"))
                .setOnMenuItemClickListener(onIconMenuItemClickListener)
                .setAnimation(MenuAnimation.SHOWUP_TOP_RIGHT)
                .setWidth(450)
                .setMenuRadius(10f)
                .setMenuShadow(10f)
                .setPadding(px2dip(getContext(), 60))
                .build();

//        加号
        TextView add_shopping = view.findViewById(R.id.add_shopping);
        add_shopping.setOnClickListener(v -> {
            onCustom(v);
        });

        CardView search_shopping = view.findViewById(R.id.search_shopping);
        search_shopping.setOnClickListener(v->{
            Intent intent_search = new Intent(getContext(), SearchActivity.class);
            intent_search.putExtra("type", "shopping");
            startActivity(intent_search);
        });

        RecyclerView shopping_lists = view.findViewById(R.id.shopping_lists);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, 1);
        shopping_lists.setLayoutManager(staggeredGridLayoutManager);
        ShoppingListsAdapter shoppingListsAdapter = new ShoppingListsAdapter(getContext());
        shopping_lists.setAdapter(shoppingListsAdapter);

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