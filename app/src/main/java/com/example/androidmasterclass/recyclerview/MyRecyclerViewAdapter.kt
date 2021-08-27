package com.example.androidmasterclass.recyclerview

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.androidmasterclass.R

class MyRecyclerViewAdapter() : RecyclerView.Adapter<MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater: LayoutInflater = LayoutInflater.from(parent.context)
        val listItem = layoutInflater.inflate(R.layout.list_item, parent, false)
        return MyViewHolder(listItem)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.view.setBackgroundColor(Color.RED)
        holder.view.findViewById<TextView>(R.id.name_text_view).text = "Hi from onBindViewHolder $position"
    }

    override fun getItemCount(): Int {
        return 5
    }
}

class MyViewHolder(val view: View) : RecyclerView.ViewHolder(view)