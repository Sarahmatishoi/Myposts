package com.example.mypostsy

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CommentViewAdapter (var commetList: List<Comments>):RecyclerView.Adapter<CommentViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentViewHolder {
        var itemView=LayoutInflater.from(parent.context).inflate(R.layout.comment_list_item,parent,false)
        return CommentViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CommentViewHolder, position: Int) {
        var currentComments=commetList.get(position)
        holder.tvEmail.text=currentComments.Email
        holder.tvBody.text=currentComments.Body
        holder.tvName.text=currentComments.Names

    }

    override fun getItemCount(): Int {
       return commetList.size
    }
}
class CommentViewHolder(itemView: List<Comments>): RecyclerView.ViewHolder(itemView){
   var tvName=itemView.findViewById<TextView>(R.id.tvNames)
    var tvEmail=itemView.findViewById<TextView>(R.id.tvEmail)
    var tvBody=itemView.findViewById<TextView>(R.id.tvBody)
}