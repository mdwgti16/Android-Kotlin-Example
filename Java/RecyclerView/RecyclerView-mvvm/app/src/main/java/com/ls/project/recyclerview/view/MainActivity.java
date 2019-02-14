package com.ls.project.recyclerview.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.ls.project.recyclerview.R;
import com.ls.project.recyclerview.adapter.ListRecyclerViewAdapter;
import com.ls.project.recyclerview.databinding.ActivityMainBinding;
import com.ls.project.recyclerview.model.ListItem;
import com.ls.project.recyclerview.viewmodel.MainViewModel;
import com.ls.project.recyclerview.viewmodel.ViewModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private MainViewModel viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new MainViewModel();
        viewModel.onCreate();
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setViewModel(viewModel);
    }

    @Override
    protected void onPause() {
        viewModel.onPause();
        super.onPause();
    }

    @Override
    protected void onResume() {
        viewModel.onResume();
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        viewModel.onDestroy();
        super.onDestroy();
    }
}
