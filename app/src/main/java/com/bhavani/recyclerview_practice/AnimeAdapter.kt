package com.bhavani.recyclerview_practice

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AnimeAdapter(var itemList: List<Items>): RecyclerView.Adapter<AnimeAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view:View = LayoutInflater.from(parent.context).inflate(R.layout.items_rv,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title1.text = itemList[position].title
        holder.image1.setImageResource(itemList[position].image)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    inner class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        val image1:ImageView = itemView.findViewById(R.id.imageRv)
        val title1:TextView = itemView.findViewById(R.id.titleRv)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setFilteredList(itemList: List<Items>){
        this.itemList = itemList
        notifyDataSetChanged()
    }
}