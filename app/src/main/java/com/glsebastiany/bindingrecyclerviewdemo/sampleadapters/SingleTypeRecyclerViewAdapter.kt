package com.glsebastiany.bindingrecyclerviewdemo.sampleadapters

import com.glsebastiany.bindingrecyclerview.BindingListRecyclerView
import com.glsebastiany.bindingrecyclerviewdemo.sampleadapters.viewmodels.TitleViewModel

class SingleTypeRecyclerViewAdapter : BindingListRecyclerView<TitleViewModel>() {

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