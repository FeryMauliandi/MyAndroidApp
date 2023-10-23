package com.example.projectakhir

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ListMenuAdapter(private val listMenu: ArrayList<Menu>) : RecyclerView.Adapter<ListMenuAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_menu, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, description, price, photo) = listMenu[position]
        Glide.with(holder.itemView.context)
            .load(photo)
            .apply(RequestOptions())
            .into(holder.imgPhoto)
        holder.tvName.text = name
        holder.tvDescription.text = description

        val mContext = holder.itemView.context

        holder.itemView.setOnClickListener {
            val moveDetail = Intent(mContext, DetailMenu::class.java)
            moveDetail.putExtra(DetailMenu.EXTRA_PHOTO, photo)
            moveDetail.putExtra(DetailMenu.EXTRA_TITLE, name)
            moveDetail.putExtra(DetailMenu.EXTRA_DESC, description)
            moveDetail.putExtra(DetailMenu.EXTRA_PRICE, price)
            mContext.startActivity(moveDetail)
        }
    }

    override fun getItemCount(): Int = listMenu.size

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        val tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        val tvDescription: TextView = itemView.findViewById(R.id.tv_item_description)
    }

}