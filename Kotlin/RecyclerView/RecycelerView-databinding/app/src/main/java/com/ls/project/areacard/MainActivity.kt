package com.ls.project.areacard

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.ls.project.areacard.adapter.ListRecyclerViewAdapter
import com.ls.project.areacard.bindings.BaseRecyclerViewAdapter
import com.ls.project.areacard.databinding.ActivityMainBinding
import com.ls.project.areacard.databinding.ItemListBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var items: ArrayList<ListItem>
    var adapter = BaseRecyclerViewAdapter<ListItem, ItemListBinding>(R.layout.item_list, BR.item)
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        items = arrayListOf<ListItem>()
        for (i in 0..10) {
            items.add(ListItem("구역 $i", "${i * 10}"))
        }


        binding.main = this
    }
}
