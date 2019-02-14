package com.ls.project.recyclerview.viewmodel;

import android.support.v7.widget.RecyclerView;

import com.ls.project.recyclerview.adapter.ListRecyclerViewAdapter;
import com.ls.project.recyclerview.model.ListItem;

import java.util.ArrayList;

public class MainViewModel implements ViewModel {
    public ListRecyclerViewAdapter mAdapter;
    private ArrayList<ListItem> items;

    @Override
    public void onCreate() {

        items = new ArrayList<>();
        for(int i =1;i<10;i++ ) {
            items.add(new ListItem("구역 "+String.valueOf(i),String.valueOf(i)+" 층",String.valueOf(i*10)));
        }
        mAdapter = new ListRecyclerViewAdapter(items);

    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onResume() {

    }
}
