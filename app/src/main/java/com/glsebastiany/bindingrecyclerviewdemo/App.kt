package com.glsebastiany.bindingrecyclerviewdemo

import android.app.Application
import com.glsebastiany.bindingrecyclerview.BindingRecyclerViewConfig


class App : Application() {

    override fun onCreate() {
        super.onCreate()

        BindingRecyclerViewConfig.init(object : BindingRecyclerViewConfig.ViewModelBrId() {
            override val id: Int = BR.viewModel
        })
    }
}