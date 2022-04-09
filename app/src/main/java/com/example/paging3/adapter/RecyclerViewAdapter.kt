package com.example.paging3.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.paging3.R
import com.example.paging3.response.ResultDAta
import com.squareup.picasso.Picasso

class RecyclerViewAdapter :PagingDataAdapter<ResultDAta,RecyclerViewAdapter.RecyclerViewHolder>(DiffUtilCallback()) {



    override fun onBindViewHolder(holder: RecyclerViewAdapter.RecyclerViewHolder, position: Int) {
        holder.bind(getItem(position)!!)
        Log.d("TAG", "onBindViewHolder: "+getItem(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
       val inflater=LayoutInflater.from(parent.context).inflate(R.layout.row_list,parent,false)
        return RecyclerViewHolder(inflater)
    }



     class RecyclerViewHolder(view:View) : RecyclerView.ViewHolder(view){

        val imageView:ImageView=view.findViewById(R.id.image)
        val headLine:TextView=view.findViewById(R.id.head)

        fun bind(item: ResultDAta) {
            headLine.text=item.name
            Picasso.get().load(item.image).into(imageView)
        }
    }

    class DiffUtilCallback:DiffUtil.ItemCallback<ResultDAta>(){

        override fun areItemsTheSame(oldItem: ResultDAta, newItem: ResultDAta): Boolean {
            return oldItem.name==newItem.name
        }

        override fun areContentsTheSame(oldItem: ResultDAta, newItem: ResultDAta): Boolean {
            return oldItem.name==newItem.name &&
                    oldItem.species==newItem.species
        }
    }
}