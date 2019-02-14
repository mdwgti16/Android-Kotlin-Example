package com.ls.project.recyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRcyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<ListItem> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRcyclerView = findViewById(R.id.recyclerView);
        mRcyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRcyclerView.setLayoutManager(mLayoutManager);

        items = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            items.add(new ListItem("구역 " + String.valueOf(i), String.valueOf(i) + " 층", String.valueOf(i * 10)));
        }
        mAdapter = new ListRecyclerViewAdapter(items);

        mRcyclerView.setAdapter(mAdapter);

    }
}
