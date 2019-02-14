package com.ls.project.recyclerview;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import com.ls.project.recyclerview.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView.Adapter mAdapter;
    private ActivityMainBinding binding;
    private ArrayList<ListItem> items;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        binding.recyclerView.setHasFixedSize(true);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));

        items = new ArrayList<>();
        for(int i =1;i<10;i++ ) {
            items.add(new ListItem("구역 "+String.valueOf(i),String.valueOf(i)+" 층",String.valueOf(i*10)));
        }
        mAdapter = new ListRecyclerViewAdapter(items);

        binding.recyclerView.setAdapter(mAdapter);

    }
}
