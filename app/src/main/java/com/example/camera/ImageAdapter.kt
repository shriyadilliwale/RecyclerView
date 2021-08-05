package com.example.camera

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import java.io.File


  class ImageAdapter : RecyclerView.Adapter<ImageAdapter.ViewHolder>(){

      private val itemTitles = arrayOf("text1","text2","text3","text4","text5","text6","text7")
      private val itemDetails1 = arrayOf("Delivered On","Delivered On","Delivered On","Delivered On","Delivered On","Delivered On","Delivered On","Delivered On")
      private val itemDetails2 = arrayOf("Result On","Result On","Result On","Result On","Result On","Result On","Result On")
      private val itemImages = intArrayOf(
          R.drawable.e,
          R.drawable.f,
          R.drawable.f1,
          R.drawable.dgdf,
          R.drawable.mmogra,
          R.drawable.mogra,
          R.drawable.n

      )

      inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
          var image: ImageView
          var textTitle: TextView
          var textDes1: TextView
          var textDes2: TextView

          init {
              image = itemView.findViewById<ImageView>(R.id.item_image)
              textTitle = itemView.findViewById(R.id.item_title)
              textDes1 = itemView.findViewById(R.id.item_details1)
              textDes2 = itemView.findViewById(R.id.item_details2)
          }
      }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.raw_image_selection, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    holder.textTitle.text= itemTitles[position]
    holder.textDes1.text= itemDetails1[position]
    holder.textDes2.text= itemDetails2[position]
    holder.image.setImageResource(itemImages[position])



    holder.itemView.setOnClickListener{v:View ->
        Toast.makeText(v.context,"Clicked on the item",Toast.LENGTH_SHORT).show()
    }
    }

      override fun getItemCount(): Int {
          return itemTitles.size
      }


  }

