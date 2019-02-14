package com.ls.project.areacard.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.ls.project.areacard.BR
import com.ls.project.areacard.ListItem
import com.ls.project.areacard.databinding.ItemListBinding

class ListRecyclerViewAdapter(var items: List<ListItem>) :
    RecyclerView.Adapter<ListRecyclerViewAdapter.GenericViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, pos: Int): GenericViewHolder {
        var binding = ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GenericViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: GenericViewHolder, pos: Int) {
        holder.bind(items[pos])
    }

    class GenericViewHolder(var binding: ItemListBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ListItem) {
            binding.setVariable(BR.item, item)
            binding.executePendingBindings()
        }
    }
}