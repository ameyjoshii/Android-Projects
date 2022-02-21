package com.example.newsapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class NewsAdapter( private val listener: ItemClicked): RecyclerView.Adapter<NewsVH>() {

    private val items : ArrayList<NewsData> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsVH {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_view, parent,false)
        val viewHolder = NewsVH(view)
        view.setOnClickListener{
            listener.onItemClick(items[viewHolder.adapterPosition])
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: NewsVH, position: Int) {
        val currentItem = items[position]
        holder.newsHeading.text = currentItem.title
        holder.newsInfo.text = currentItem.description
        Glide.with(holder.itemView.context).load(currentItem.urlToImage).into(holder.image)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun updateNewsData(updatedNewsData: ArrayList<NewsData>){
        items.clear()
        items.addAll(updatedNewsData)

        notifyDataSetChanged()
    }

}


class NewsVH(itemView: View): RecyclerView.ViewHolder(itemView){
    val newsHeading: TextView = itemView.findViewById(R.id.newsheading)
    val newsInfo : TextView = itemView.findViewById(R.id.newsinfo)
    val image : ImageView = itemView.findViewById(R.id.imageitem)
}

interface ItemClicked{
    fun onItemClick(item: NewsData)
}