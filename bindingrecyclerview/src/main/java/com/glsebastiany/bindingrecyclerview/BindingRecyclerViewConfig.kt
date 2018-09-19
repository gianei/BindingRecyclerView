package com.glsebastiany.bindingrecyclerview

object BindingRecyclerViewConfig {

    private var viewModelBRId: ViewModelBrId? = null

    fun init(viewModelBRId: ViewModelBrId) {
        this.viewModelBRId = viewModelBRId
    }

    internal fun provideViewModelBrId(): Int {
        return viewModelBRId?.id
                ?: throw Exception("BindingRecyclerView was not initialized! You must call BindingRecyclerView.init before using it.")

    }

    abstract class ViewModelBrId {
        abstract val id: Int
    }

}

