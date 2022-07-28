package com.example.mvvm.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm.R
import com.example.mvvm.models.RecyclerList

class RecyclerViewAdapter: RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>() {

     var items = ArrayList<RecyclerList>()

    fun setUpdatedData(items: ArrayList<RecyclerList>) {
        this.items = items
        notifyDataSetChanged()
    }

    class MyViewHolder (view: View): RecyclerView.ViewHolder (view) {
        val tvTitle =  view.findViewById<TextView>(R.id.tvTitle)
        val tvDesc = view.findViewById<TextView>(R.id.tvDesc)

        fun bind (data : RecyclerList){
            tvTitle.text = data.title
            tvDesc.text = data.body
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_list_row, parent, false )
        return MyViewHolder(view)

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
    return items.size
    }
}