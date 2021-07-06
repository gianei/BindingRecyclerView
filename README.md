# BindingRecyclerView
[![](https://jitpack.io/v/gianei/BindingRecyclerView.svg)](https://jitpack.io/#gianei/BindingRecyclerView)

Reduce boilerplate code with RecyclerViews by using Android's data binding and naming convention.



## Example
Create an adapter extending `BindingRecyclerView`, similarly to RecyclerView,
 provide a list of elements and override a few methods:

```
class MyRecyclerViewAdapter : BindingRecyclerView<TitleViewModel>() {

    var viewModels = listOf<BindingRecyclerView.BindableViewHolder>()
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
    
}
```

You must have a ViewModel that extends `BindingRecyclerView.BindableViewHolder`:
```
data class TitleViewModel(
        val title: String,
        val clickCallback: (() -> Unit)? = null
) : BindingRecyclerView.BindableViewHolder {

    override val layoutId: Int = R.layout.title_view_item

}
```

And your layout:
```
<layout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools">

    <data>

        <variable
            name="viewModel"
            type="package.name.TitleViewModel" />

    </data>

    <FrameLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="horizontal">

        <TextView
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:text="@{viewModel.title}" />

    </FrameLayout>

</layout>
```



## Configuration
All item layouts of the recycler view must have a variable named `viewModel`. In your application class you must inform the `BR`
id of the variable into `BindingRecyclerViewConfig`.

Simply as this:

```
class App: Application() {

    override fun onCreate() {
        super.onCreate()

        BindingRecyclerViewConfig.init(object: BindingRecyclerViewConfig.ViewModelBrId() {
            override val id: Int = BR.viewModel
        })
    }
}
```



## Aditional info
In case you need you need a recycler view different layouts, we got you covered!
Simply provide multiple implementations of `BindingRecyclerView.BindableViewHolder`.

If you are creating an Adapter based on a List you can use the following 
implementations of `BindingRecyclerView`:
* `BindingMutableListRecyclerView`
* `BindingListRecyclerView`


## Get it
Add the JitPack repository to your root build.gradle:
```
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```

Add the dependency
```
repositories {
    implementation 'com.github.gianei:BindingRecyclerView:2.2.0'
}
```