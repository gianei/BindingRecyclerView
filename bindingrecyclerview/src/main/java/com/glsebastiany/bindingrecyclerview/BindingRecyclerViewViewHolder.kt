package com.glsebastiany.bindingrecyclerview

import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView

class BindingRecyclerViewViewHolder<in T>(val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bindModel(model: T) {
        binding.setVariable(BindingRecyclerViewConfig.provideViewModelBrId(), model)
        binding.executePendingBindings()
    }

}