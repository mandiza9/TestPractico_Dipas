package com.example.testapracticodipas.adapter

import android.content.Context
import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.testapracticodipas.R
import com.example.testapracticodipas.model.GamesList

class RecyclerViewAdapter(
    dataList: List<GamesList>,var context: Context
): RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>(){

    private var list = dataList

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name: TextView = view.findViewById(R.id.name)
        val background_image: ImageView = view.findViewById(R.id.image)
        val slug: TextView = view.findViewById(R.id.des)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_view_item, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = list[position]

        holder.name.text = data.name
        holder.slug.text = data.slug

        val requestOptions = RequestOptions()
        requestOptions.placeholder(R.drawable.ic_launcher_background)

        Glide.with(context)
            .setDefaultRequestOptions(requestOptions)
            .load( data.background_image )
            .override(500,500)
            .centerCrop()
            .into( holder.background_image )

    }

}