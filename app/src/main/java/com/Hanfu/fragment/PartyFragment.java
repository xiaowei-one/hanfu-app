package com.Hanfu.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.Hanfu.R;
import com.Hanfu.adapter.HotAdapter;
import com.Hanfu.domain.IconPowerMenuItem;
import com.Hanfu.pages.PartyActivity;
import com.Hanfu.pages.SearchActivity;
import com.Hanfu.pages.ShoppingActivity;
import com.Hanfu.utils.IconMenuAdapter;
import com.skydoves.powermenu.CustomPowerMenu;
import com.skydoves.powermenu.MenuAnimation;
import com.skydoves.powermenu.OnMenuItemClickListener;

import static com.Hanfu.utils.Utils.px2dip;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PartyFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PartyFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private CustomPowerMenu customPowerMenu;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private final OnMenuItemClickListener<IconPowerMenuItem> onIconMenuItemClickListener = (position, item) -> {
        Intent intent = new Intent(getContext(), PartyActivity.class);
        if(position == 0){
            intent.putExtra("type", "sendParty");
            startActivity(intent);
        }
        customPowerMenu.dismiss();
    };

    public PartyFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PartyFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PartyFragment newInstance(String param1, String param2) {
        PartyFragment fragment = new PartyFragment();
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

        View view = inflater.inflate(R.layout.fragment_party, container, false);

        //选择查询条件部分
        customPowerMenu = new CustomPowerMenu.Builder<>(getContext(), new IconMenuAdapter())
                .addItem(new IconPowerMenuItem(ContextCompat.getDrawable(getContext(), R.mipmap.add_text), "发活动"))
                .addItem(new IconPowerMenuItem(ContextCompat.getDrawable(getContext(), R.mipmap.add_video1), "发视频"))
                .addItem(new IconPowerMenuItem(ContextCompat.getDrawable(getContext(), R.mipmap.drafts), "草稿箱"))
                .setOnMenuItemClickListener(onIconMenuItemClickListener)
                .setAnimation(MenuAnimation.SHOWUP_TOP_RIGHT)
                .setWidth(400)
                .setMenuRadius(10f)
                .setMenuShadow(10f)
                .setPadding(px2dip(getContext(), 60))
                .build();

//        加号
        TextView add_party = view.findViewById(R.id.add_party);

//        线下活动
        LinearLayout offline_party = view.findViewById(R.id.offline_party);
//        线上活动
        LinearLayout online_competition = view.findViewById(R.id.online_competition);

        add_party.setOnClickListener(v -> {
            onCustom(v);
        });

        Intent intent = new Intent(getContext(), PartyActivity.class);
        offline_party.setOnClickListener(v -> {
            intent.putExtra("type", "offline_party");
            startActivity(intent);
        });

        online_competition.setOnClickListener(v -> {
            intent.putExtra("type", "online_competition");
            startActivity(intent);
        });

        CardView search_party = view.findViewById(R.id.search_party);
        search_party.setOnClickListener(v->{
            Intent intent_search = new Intent(getContext(), SearchActivity.class);
            intent_search.putExtra("type", "party");
            startActivity(intent_search);
        });

//        热门穿搭
        RecyclerView hot_wear = view.findViewById(R.id.hot_wear);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false);
        hot_wear.setLayoutManager(linearLayoutManager);
        HotAdapter hotAdapter = new HotAdapter(getContext());
        hot_wear.setAdapter(hotAdapter);
//       热门活动
        RecyclerView hot_party = view.findViewById(R.id.hot_party);
        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false);
        hot_party.setLayoutManager(linearLayoutManager1);
        HotAdapter hotAdapter1 = new HotAdapter(getContext());
        hot_party.setAdapter(hotAdapter1);

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