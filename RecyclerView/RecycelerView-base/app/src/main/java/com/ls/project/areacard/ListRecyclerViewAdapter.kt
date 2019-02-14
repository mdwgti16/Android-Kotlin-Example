package com.ls.project.areacard

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_list.view.*


class ListRecyclerViewAdapter(var items: List<ListItem>): RecyclerView.Adapter<ListRecyclerViewAdapter.GenericViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, pos: Int): GenericViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_list ,parent,false)

        return GenericViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: GenericViewHolder, pos: Int) {
        holder.bind(items[pos])
    }

    class GenericViewHolder(var view: View):RecyclerView.ViewHolder(view) {
        fun bind(item : ListItem){
            view.areaNum.text=item.areaName
            view.date.text=item.date
        }
    }

}
