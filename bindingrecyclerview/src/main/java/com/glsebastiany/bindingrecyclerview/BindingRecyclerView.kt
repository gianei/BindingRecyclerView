package com.glsebastiany.bindingrecyclerview

import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

abstract class BindingRecyclerView<T> : RecyclerView.Adapter<BindingRecyclerViewViewHolder<T>>() where T : BindingRecyclerView.BindableViewHolder {

    final override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindingRecyclerViewViewHolder<T> {

        val binding = DataBindingUtil.inflate<ViewDataBinding>(
                LayoutInflater.from(parent.context),
                viewType,
                parent,
                false
        )

        onCreateViewHolderBinding(binding)
        return BindingRecyclerViewViewHolder(binding)
    }

    final override fun onBindViewHolder(holder: BindingRecyclerViewViewHolder<T>,
                                        position: Int) {
        val model = getViewModelForPosition(position)
        holder.bindModel(model)
        onBindViewHolderBinding(holder.binding, position)
    }

    final override fun getItemViewType(position: Int): Int {
        return getViewModelForPosition(position).layoutId
    }

    /**
     * Is called just after [RecyclerView.Adapter.onCreateViewHolder]
     * Use this event to further customize your layout binding as you would in [RecyclerView.Adapter.onCreateViewHolder]
     */
    open fun onCreateViewHolderBinding(binding: ViewDataBinding) {}

    /**
     * Is called just after [RecyclerView.Adapter.onBindViewHolder]
     * Use this event to further customize your layout binding as you would in [RecyclerView.Adapter.onBindViewHolder]
     */
    open fun onBindViewHolderBinding(binding: ViewDataBinding, position: Int) {}

    abstract fun getViewModelForPosition(position: Int): T

    interface BindableViewHolder {
        val layoutId: Int
    }

}