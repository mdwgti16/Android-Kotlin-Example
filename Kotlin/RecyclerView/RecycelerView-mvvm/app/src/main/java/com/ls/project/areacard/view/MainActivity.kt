package com.ls.project.areacard.view

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.ls.project.areacard.R
import com.ls.project.areacard.databinding.ActivityMainBinding
import com.ls.project.areacard.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = MainViewModel()
        binding.viewModel = viewModel
        viewModel.onCreate()
    }

    override fun onResume() {
        viewModel.onResume()
        super.onResume()
    }

    override fun onPause() {
        viewModel.onPause()
        super.onPause()
    }

    override fun onDestroy() {
        viewModel.onDestroy()
        super.onDestroy()
    }


}
