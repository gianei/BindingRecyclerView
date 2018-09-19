package com.glsebastiany.bindingrecyclerviewdemo

import com.glsebastiany.bindingrecyclerview.BindingRecyclerView
import com.glsebastiany.bindingrecyclerviewdemo.R

class RecyclerViewAdapter : BindingRecyclerView<RecyclerViewAdapter.ViewModel>() {

    override fun getLayoutIdForPosition(position: Int): Int {
        return R.layout.recycler_view_item
    }

    data class ViewModel(
            val text: String
    )

    companion object {
        fun getSampleAdapter(): RecyclerViewAdapter {
            return RecyclerViewAdapter().apply {
                viewModels = mutableListOf(
                        ViewModel("Text 1"),
                        ViewModel("Text 2"),
                        ViewModel("Text 3"),
                        ViewModel("Text 4"),
                        ViewModel("Text 5")
                )
            }
        }
    }

}