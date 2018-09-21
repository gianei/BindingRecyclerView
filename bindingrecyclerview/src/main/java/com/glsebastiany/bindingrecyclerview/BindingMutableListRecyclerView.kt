package com.glsebastiany.bindingrecyclerview

open class BindingMutableListRecyclerView<T> : BindingRecyclerView<T>() where T : com.glsebastiany.bindingrecyclerview.BindingRecyclerView.BindableViewHolder {

    var viewModels = mutableListOf<T>()

    override fun getViewModelForPosition(position: Int): T {
        return viewModels[position]
    }

    override fun getItemCount(): Int {
        return viewModels.size
    }

}