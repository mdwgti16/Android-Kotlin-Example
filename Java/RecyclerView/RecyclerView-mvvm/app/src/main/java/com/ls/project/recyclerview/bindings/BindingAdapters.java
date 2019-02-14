package com.ls.project.recyclerview.bindings;

import android.databinding.BindingAdapter;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.ls.project.recyclerview.adapter.ListRecyclerViewAdapter;

public class BindingAdapters {
    @BindingAdapter("bind:setAdapter")
    public static void setAdapter(RecyclerView recyclerView, ListRecyclerViewAdapter adapter) {
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);

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
