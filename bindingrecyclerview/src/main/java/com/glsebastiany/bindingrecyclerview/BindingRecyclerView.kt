package com.glsebastiany.bindingrecyclerview

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

abstract class BindingRecyclerView<T> : RecyclerView.Adapter<BindingRecyclerViewViewHolder<T>>() {

    var viewModels = mutableListOf<T>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindingRecyclerViewViewHolder<T> {

        val binding = DataBindingUtil.inflate<ViewDataBinding>(
                LayoutInflater.from(parent.context),
                viewType,
                parent,
                false
        )

        return BindingRecyclerViewViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BindingRecyclerViewViewHolder<T>,
                                  position: Int) {
        val model = viewModels[position]
        holder.bindModel(model)

    }

    override fun getItemViewType(position: Int): Int {
        return getLayoutIdForPosition(position)
    }

    override fun getItemCount(): Int {
        return viewModels.count()
    }

    protected abstract fun getLayoutIdForPosition(position: Int): Int

}