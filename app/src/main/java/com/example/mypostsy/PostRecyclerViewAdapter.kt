package com.example.mypostsy

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class PostRecyclerViewAdapter (var postList: List<Post>,var context: Context):RecyclerView.Adapter<postViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): postViewHolder {
        var itemView=LayoutInflater.from(parent.context).inflate(R.layout.post_list_item,parent,false)
        return postViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: postViewHolder, position: Int) {
        var currentPosts=postList.get(position)
       holder.user.text=currentPosts.userId.toString()
        holder.body.text=currentPosts.body.toString()
        holder.title.text=currentPosts.title.toString()
        holder.userId.text=currentPosts.id.toString()
        holder.cvpost.setOnClickListener{
            var intent=Intent(context,CommentActivity::class.java)
            intent.putExtra("POST_id",currentPosts.id)
            context.startActivity(intent)

        }
    }

    override fun getItemCount(): Int {
       return postList.size
    }
}
class postViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
    var cvpost=itemView.findViewById<CardView>(R.id.cvPost)
    var user=itemView.findViewById<TextView>(R.id.tvuser)
    var userId=itemView.findViewById<TextView>(R.id.tvuserId)
    var body=itemView.findViewById<TextView>(R.id.tvbody)
    var title=itemView.findViewById<TextView>(R.id.tvtitle)
}
