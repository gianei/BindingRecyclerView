package com.glsebastiany.bindingrecyclerviewdemo.sampleadapters.viewmodels

import com.glsebastiany.bindingrecyclerview.BindingRecyclerView
import com.glsebastiany.bindingrecyclerviewdemo.R

data class TitleViewModel(
        val title: String,
        val clickCallback: (() -> Unit)? = null
) : BindingRecyclerView.BindableViewHolder {

    override val layoutId: Int = R.layout.title_view_item

}