package com.example.recyclerview_api_kotlin.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview_api_kotlin.R
import com.example.recyclerview_api_kotlin.model.Movie
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.layout_movie_item.view.*

class MyAdapter(private val context: Context ,private val movieList: MutableList<Movie>):RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder
    {

        var itemView = LayoutInflater.from(context).inflate(R.layout.layout_movie_item,parent,false)
        return  MyViewHolder(itemView)

    }

    override fun getItemCount(): Int
    {
            return movieList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int)
    {

Picasso.get().load(movieList[position].link).into(holder.image)
        holder.txt_namem.text = movieList[position].name
        holder.txt_teamm.text = movieList[position].id



    }

    class MyViewHolder(itemView :View) : RecyclerView.ViewHolder(itemView)
    {

        var image : ImageView
        var txt_namem : TextView
        var txt_teamm : TextView

        init {
            image = itemView.image_movie
            txt_namem = itemView.txt_name
            txt_teamm = itemView.txt_team
        }

    }


}