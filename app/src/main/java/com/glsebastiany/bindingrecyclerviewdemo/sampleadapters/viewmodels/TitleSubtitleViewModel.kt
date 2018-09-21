package com.glsebastiany.bindingrecyclerviewdemo.sampleadapters.viewmodels

import com.glsebastiany.bindingrecyclerview.BindingRecyclerView
import com.glsebastiany.bindingrecyclerviewdemo.R

data class TitleSubtitleViewModel(
        val title: String,
        val subtitle: String
) : BindingRecyclerView.BindableViewHolder {

    override val layoutId: Int = R.layout.title_subtitle_view_item

}