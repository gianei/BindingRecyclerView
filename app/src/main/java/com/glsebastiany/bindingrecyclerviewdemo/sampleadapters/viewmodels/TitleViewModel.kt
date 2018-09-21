package com.glsebastiany.bindingrecyclerviewdemo.sampleadapters.viewmodels

data class TitleViewModel(
        val title: String,
        val clickCallback: (() -> Unit)? = null
)