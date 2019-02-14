package com.ls.project.areacard

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.ls.project.areacard.adapter.ListRecyclerViewAdapter
import com.ls.project.areacard.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var items: ArrayList<ListItem>
    private lateinit var adapter: ListRecyclerViewAdapter
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        items = arrayListOf<ListItem>()
        for (i in 0..10) {
            items.add(ListItem("구역 $i", "${i * 10}"))
        }
        adapter = ListRecyclerViewAdapter(items)
        binding.adapter = adapter
    }
}
