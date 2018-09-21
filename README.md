# BindingRecyclerView

Reduce boilerplate code with RecyclerViews by using Android's data binding ande naming convention.



## Example
Create an adapter extending `BindingRecyclerView` and implement the single required method:

```
class SingleTypeRecyclerViewAdapter : BindingRecyclerView<TitleViewModel>() {

    override fun getLayoutIdForPosition(position: Int): Int {
        return R.layout.title_view_item
    }
    
}
```

With your ViewModel:
```
data class TitleViewModel(
        val title: String
)
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
You only have to override one more method.

Here is a sample:
```
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
}
```

