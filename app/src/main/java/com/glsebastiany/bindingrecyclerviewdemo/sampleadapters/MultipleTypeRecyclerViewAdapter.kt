package com.glsebastiany.bindingrecyclerviewdemo.sampleadapters

import android.util.Log
import com.glsebastiany.bindingrecyclerview.BindingRecyclerView
import com.glsebastiany.bindingrecyclerview.BindingRecyclerViewViewHolder
import com.glsebastiany.bindingrecyclerviewdemo.R
import com.glsebastiany.bindingrecyclerviewdemo.databinding.TitleSubtitleViewItemBinding
import com.glsebastiany.bindingrecyclerviewdemo.sampleadapters.viewmodels.TitleSubtitleViewModel
import com.glsebastiany.bindingrecyclerviewdemo.sampleadapters.viewmodels.TitleViewModel

class MultipleTypeRecyclerViewAdapter : BindingRecyclerView<Any>() {

    override fun getLayoutIdForPosition(position: Int): Int {
        return when (viewModels[position]) {
            is TitleViewModel -> R.layout.title_view_item
            is TitleSubtitleViewModel -> R.layout.title_subtitle_view_item
            else -> throw Exception("ViewModel type is not mapped to a layout ID!")
        }
    }

    override fun onBindViewHolder(holder: BindingRecyclerViewViewHolder<Any>, position: Int, payloads: MutableList<Any>) {
        super.onBindViewHolder(holder, position, payloads)

        /**
         * If more customization is needed on the layout bindings, it can be done here
         */
        if (position == viewModels.size) {
            val textSubtitleViewModel = holder.binding as TitleSubtitleViewItemBinding
            Log.d("BINDING_ADAPTER", textSubtitleViewModel.viewModel?.title)
        }
    }

    companion object {
        fun getSampleAdapter(): MultipleTypeRecyclerViewAdapter {
            return MultipleTypeRecyclerViewAdapter().apply {
                viewModels = mutableListOf(
                        TitleViewModel("Title 1"),
                        TitleSubtitleViewModel("Text 2", "Subtitle 2"),
                        TitleViewModel("Title 3"),
                        TitleSubtitleViewModel("Title 4", "Subtitle 3"),
                        TitleSubtitleViewModel("Title 5", "Subtitle 5")
                )
            }
        }
    }

}