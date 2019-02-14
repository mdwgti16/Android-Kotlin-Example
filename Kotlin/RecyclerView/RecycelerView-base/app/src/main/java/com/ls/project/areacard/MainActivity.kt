package com.ls.project.areacard

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var items: ArrayList<ListItem>

    private lateinit var adapter: ListRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)

        items = arrayListOf()
        for (i in 0..10) {
            items.add(ListItem("구역 $i", "${i * 10}"))
        }

        adapter = ListRecyclerViewAdapter(items)
        recyclerView.adapter = adapter
    }
}
