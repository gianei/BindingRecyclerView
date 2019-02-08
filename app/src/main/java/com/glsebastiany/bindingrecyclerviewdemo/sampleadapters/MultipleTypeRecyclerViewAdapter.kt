package com.glsebastiany.bindingrecyclerviewdemo.sampleadapters

import androidx.databinding.ViewDataBinding
import android.util.Log
import com.glsebastiany.bindingrecyclerview.BindingRecyclerView
import com.glsebastiany.bindingrecyclerviewdemo.databinding.TitleSubtitleViewItemBinding
import com.glsebastiany.bindingrecyclerviewdemo.sampleadapters.viewmodels.TitleSubtitleViewModel
import com.glsebastiany.bindingrecyclerviewdemo.sampleadapters.viewmodels.TitleViewModel

class MultipleTypeRecyclerViewAdapter : BindingRecyclerView<BindingRecyclerView.BindableViewHolder>() {

    var viewModels = mutableListOf<BindingRecyclerView.BindableViewHolder>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getViewModelForPosition(position: Int): BindableViewHolder {
        return viewModels[position]
    }

    override fun getItemCount(): Int {
        return viewModels.size
    }

    override fun onBindViewHolderBinding(binding: ViewDataBinding, position: Int) {

        /**
         * If more customization is needed on the layout bindings, it can be done here
         */
        if (position == viewModels.size) {
            val textSubtitleViewModel = binding as TitleSubtitleViewItemBinding
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