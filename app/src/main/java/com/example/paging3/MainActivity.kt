package com.example.paging3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.paging3.adapter.RecyclerViewAdapter
import com.example.paging3.viewModel.PagingViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest

class MainActivity : AppCompatActivity() {

    lateinit var rvAdapter:RecyclerViewAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initRv()
        initViewModel()
    }

    private fun initViewModel() {
        val viewModel=ViewModelProvider(this).get(PagingViewModel::class.java)
        lifecycleScope.launchWhenCreated {
            viewModel.getList().collectLatest {
                rvAdapter.submitData(it)
                Log.d("TAG", "initViewModel: "+it.toString())
            }
        }

    }


    private fun initRv(){
        rv.apply {
           // layoutManager=StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)
            layoutManager=LinearLayoutManager(this@MainActivity)
            val decoration=DividerItemDecoration(applicationContext,DividerItemDecoration.VERTICAL)
            addItemDecoration(decoration)
            rvAdapter= RecyclerViewAdapter()
            adapter=rvAdapter
        }
    }

}