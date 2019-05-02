package com.ls.project.areacard.bindings

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

open class BaseViewHolder<B : ViewDataBinding>(
    layout: Int,
    parent: ViewGroup,
    private val bindingVariableId: Int?) : RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context)
                .inflate(layout, parent, false)
) {

    val b: B = DataBindingUtil.bind(itemView)!!

    fun onBindViewHolder(item: Any) {

        if (bindingVariableId == null)
            return

        b.setVariable(bindingVariableId, item)
        itemView.visibility = View.VISIBLE

        b.executePendingBindings()
    }

}
