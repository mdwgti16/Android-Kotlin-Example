package com.ls.project.areacard.bindings

import android.databinding.BindingAdapter
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.ls.project.areacard.ListItem
import com.ls.project.areacard.adapter.ListRecyclerViewAdapter
import com.ls.project.areacard.databinding.ItemListBinding

class BindingAdapter {
    companion object {
        @JvmStatic
        @BindingAdapter("bind:setAdapter")
        fun setAdapter(
            recyclerView: RecyclerView,
            adapter: BaseRecyclerViewAdapter<Any,* >
        ) {
            recyclerView.layoutManager = LinearLayoutManager(recyclerView.context)
            recyclerView.setHasFixedSize(true)
            recyclerView.adapter = adapter
        }
    }
}