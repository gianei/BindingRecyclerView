package com.glsebastiany.bindingrecyclerviewdemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.glsebastiany.bindingrecyclerviewdemo.sampleadapters.MultipleTypeRecyclerViewAdapter
import com.glsebastiany.bindingrecyclerviewdemo.sampleadapters.SingleTypeRecyclerViewAdapter

class MainActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView

    private val singleTypeAdapter = SingleTypeRecyclerViewAdapter.getSampleAdapter { recyclerView.adapter = multipleTypeAdapter }
    private val multipleTypeAdapter = MultipleTypeRecyclerViewAdapter.getSampleAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)

        recyclerView.adapter = singleTypeAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }

}
