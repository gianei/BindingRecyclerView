package com.glsebastiany.bindingrecyclerview

open class BindingListRecyclerView<T> : BindingRecyclerView<T>() where T : BindingRecyclerView.BindableViewHolder {

    var viewModels = listOf<T>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getViewModelForPosition(position: Int): T {
        return viewModels[position]
    }

    override fun getItemCount(): Int {
        return viewModels.size
    }

}