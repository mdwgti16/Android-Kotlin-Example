package com.ls.project.navigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import androidx.navigation.navArgs
import androidx.navigation.ui.NavigationUI
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_second.*
import kotlinx.android.synthetic.main.fragment_second_main.*

class SecondActivity : AppCompatActivity() {
    val args: NavGraphSecondArgs by navArgs()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        setSupportActionBar(second_toolbar)

        val navController = findNavController(R.id.second_nav_host_fragment)

        val bundle = bundleOf("message" to args.message)
        navController.setGraph(navController.graph,bundle)
    }
}
