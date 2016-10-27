package com.idkteam.idk.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.idkteam.idk.R;
import com.idkteam.idk.adapter.MainAdapter;
import com.idkteam.idk.model.DemoData;
import com.idkteam.idk.model.PostItem;

import java.util.ArrayList;

/**
 * Created by Danny on 27/08/2016.
 */
public class TabFragmentMain extends Fragment implements MainAdapter.ItemClickCallBack {

    private static final String BUNDLE_EXTRAS = "BUNDLE_EXTRAS";
    private static final String EXTRA_QUOTE = "EXTRA_QUOTE";
    private static final String EXTRA_ATTR = "EXTRA_ATTR";
    private RecyclerView recView;
    private MainAdapter mainAdapter;
    private ArrayList listData;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.tab_fragment_main, container, false);

        //Add RecycleView
        listData = (ArrayList) DemoData.getListData();
        recView = (RecyclerView) rootView.findViewById(R.id.main_recycleView);
        recView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mainAdapter = new MainAdapter(DemoData.getListData(), getActivity());
        recView.setAdapter(mainAdapter);
        mainAdapter.setItemClickCallBack(this);
        return rootView;
    }

    @Override
    public void onItemClick(int p) {

        PostItem item = (PostItem) listData.get(p);
        Intent i = new Intent(this.getContext(), PostDetail.class);
        Bundle extras = new Bundle();

        extras.putString(EXTRA_QUOTE, item.getTitle());
        extras.putString(EXTRA_ATTR, item.getSubTitle());
        i.putExtra(BUNDLE_EXTRAS, extras);
        startActivity(i);
    }

    @Override
    public void onSecondaryIconClick(int p) {

    }
}
