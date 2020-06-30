package com.glsebastiany.bindingrecyclerviewdemo.sampleadapters

import android.util.Log
import androidx.databinding.ViewDataBinding
import com.glsebastiany.bindingrecyclerview.BindingRecyclerView
import com.glsebastiany.bindingrecyclerviewdemo.sampleadapters.viewmodels.TitleSubtitleViewModel
import com.glsebastiany.bindingrecyclerviewdemo.sampleadapters.viewmodels.TitleViewModel

class MultipleTypeRecyclerViewAdapter : BindingRecyclerView<BindingRecyclerView.BindableViewHolder>() {

    var viewModels = mutableListOf<BindableViewHolder>()
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

    override fun onCreateViewHolderBinding(binding: ViewDataBinding) {

        /**
         * If more customization is needed on creation of layout, it can be done here
         */
        Log.d("BINDING_ADAPTER_CREATE", "Binding ${binding::class.simpleName} created")

    }

    override fun onBindViewHolderBinding(binding: ViewDataBinding, position: Int) {

        /**
         * If more customization is needed on binding of layout, it can be done here
         */
        Log.d("BINDING_ADAPTER_BIND", "Binding ${binding::class.simpleName} bind")

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