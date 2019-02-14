package com.ls.project.areacard.bindings

import android.databinding.BindingAdapter
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.ls.project.areacard.adapter.ListRecyclerViewAdapter

class BindingAdapter {
    companion object {
        @JvmStatic
        @BindingAdapter("bind:setAdapter")
        fun setAdapter(
            recyclerView: RecyclerView,
            adapter: ListRecyclerViewAdapter
        ) {
            recyclerView.layoutManager = LinearLayoutManager(recyclerView.context)
            recyclerView.setHasFixedSize(true)
            recyclerView.adapter = adapter

            /** 3 */
//            recyclerView.addOnItemTouchListener(object :
//                RecyclerViewListener(recyclerView.context, recyclerView, object : RecyclerViewListener.OnItemClickListener {
//                    override fun onItemClick(view: View, position: Int) {
//                        Toast.makeText(recyclerView.context,"${adapter.items[position].areaName} ${adapter.items[position].date} Listener ",
//                            Toast.LENGTH_SHORT).show()
//                    }
//
//                    override fun onLongItemClick(view: View?, position: Int) {
//                        Toast.makeText(recyclerView.context,"${adapter.items[position].areaName} ${adapter.items[position].date} Listener Long ",
//                            Toast.LENGTH_SHORT).show()
//                    }
//                }){})
        }
    }
}