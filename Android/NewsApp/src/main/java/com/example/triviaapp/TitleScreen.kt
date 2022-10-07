package com.example.triviaapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import java.util.ArrayList

class TitleScreen(private val listener:itemclicked): RecyclerView.Adapter<TriviaViewHolder>() {
    private val items : ArrayList<News> = ArrayList()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TriviaViewHolder {
        //jitni baar bhi viewholder call hoga utni baar yeh call hoga
        val view=LayoutInflater.from(parent.context).inflate(R.layout.item_trivia,parent,false)
        //upar wali line xml file ko 1 view banane ka kaam kar rhi hai
        val viewholder = TriviaViewHolder(view)
        //setonclicklistener aur interface view ke clicking sambhaal rahe hai
        view.setOnClickListener{
            listener.onitemclicked(items[viewholder.absoluteAdapterPosition])
        }
        return viewholder

    }

    override fun onBindViewHolder(holder: TriviaViewHolder, position: Int) {
        //viewholder ke andar data ko bind karta hai
        val currentitem=items[position]
        holder.titleview.text=currentitem.title
        holder.author.text=currentitem.author
        Glide.with(holder.itemView.context).load(currentitem.imageurl).into(holder.image)

    }

    override fun getItemCount(): Int {
        //sirf 1 baar call hota hai aur batata hai ki kitne item list me rehne wale hai
        return items.size
    }
    fun updateNews(updatedNews:ArrayList<News>){
        items.clear()
        items.addAll(updatedNews)
        notifyDataSetChanged()
    }

}
class TriviaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val titleview:TextView=itemView.findViewById(R.id.title)
    val image:ImageView=itemView.findViewById(R.id.image)
    val author:TextView=itemView.findViewById(R.id.author)
}
interface itemclicked{
    fun onitemclicked(item:News)
}