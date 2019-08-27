package com.glsebastiany.bindingrecyclerview

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

class BindingRecyclerViewViewHolder<in T>(val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) where T : BindingRecyclerView.BindableViewHolder {

    fun bindModel(model: T) {
        binding.setVariable(BindingRecyclerViewConfig.provideViewModelBrId(), model)
        binding.executePendingBindings()
    }

}