package com.ls.project.areacard.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.ls.project.areacard.BR
import com.ls.project.areacard.databinding.ItemListBinding
import com.ls.project.areacard.model.ListItem


class ListRecyclerViewAdapter(var items: List<ListItem>) :
    RecyclerView.Adapter<ListRecyclerViewAdapter.GenericViewHolder>() {
    /** 1 */
//    lateinit var onClick: (View) -> Unit
    /** 2 */
//    companion object {
//        lateinit var clickListener: ClickListener
//    }

    override fun onCreateViewHolder(parent: ViewGroup, pos: Int): GenericViewHolder {
        var binding = com.ls.project.areacard.databinding.ItemListBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

//        binding.linear.setOnClickListener {
//            Toast.makeText(it.context,"fadsfds",Toast.LENGTH_SHORT).show()
//        }
        /** 1 */
//        binding.linear.setOnClickListener {
//            onClick(it)
//        }
        return GenericViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: GenericViewHolder, pos: Int) {
        holder.bind(items[pos])
    }

    fun getItemPos(pos: Int): ListItem {
        return items[pos]
    }

    inner class GenericViewHolder(var binding: ItemListBinding) : RecyclerView.ViewHolder(binding.root)
    /** 2 */
//        , View.OnClickListener, View.OnLongClickListener
    {
        fun bind(item: ListItem) {
            binding.setVariable(BR.item, item)
            /** 2 */
//            binding.linear.setOnClickListener(this)
//            binding.linear.setOnLongClickListener(this)

            binding.executePendingBindings()
        }
        /** 2 */

//        override fun onClick(v: View) {
//            clickListener.onItemClick(v,adapterPosition)
//        }
//        override fun onLongClick(v: View): Boolean {
//            clickListener.onItemLongClick(v,adapterPosition)
//            return true //false -> onClick 안됨
//        }
    }

    /** 2 */
//    fun setOnItemClickListener(clickListener: ClickListener) {
//        ListRecyclerViewAdapter.clickListener = clickListener
//    }
//    interface ClickListener {
//        fun onItemClick(v: View,pos: Int)
//        fun onItemLongClick(v: View,pos: Int)
//    }
}