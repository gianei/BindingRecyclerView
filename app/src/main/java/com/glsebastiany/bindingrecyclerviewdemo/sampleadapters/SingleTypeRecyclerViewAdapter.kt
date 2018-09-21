package com.glsebastiany.bindingrecyclerviewdemo.sampleadapters

import com.glsebastiany.bindingrecyclerview.BindingRecyclerView
import com.glsebastiany.bindingrecyclerviewdemo.R
import com.glsebastiany.bindingrecyclerviewdemo.sampleadapters.viewmodels.TitleViewModel

class SingleTypeRecyclerViewAdapter : BindingRecyclerView<TitleViewModel>() {

    override fun getLayoutIdForPosition(position: Int): Int {
        return R.layout.title_view_item
    }

    companion object {
        fun getSampleAdapter(clickCallback: (() -> Unit)): SingleTypeRecyclerViewAdapter {
            return SingleTypeRecyclerViewAdapter().apply {
                viewModels = mutableListOf(
                        TitleViewModel("Click to see adapter with multiple type VMs", clickCallback),
                        TitleViewModel("Title 2"),
                        TitleViewModel("Title 3"),
                        TitleViewModel("Title 4"),
                        TitleViewModel("Title 5")
                )
            }
        }
    }

}