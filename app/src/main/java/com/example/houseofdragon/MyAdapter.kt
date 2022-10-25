package com.example.houseofdragon

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import de.hdodenhof.circleimageview.CircleImageView

class MyAdapter(
    private val housesList: ArrayList<housesWesteros>,
    private val context: Context,
    var onItemClick: ((housesWesteros) -> Unit)? = null
) : RecyclerView.Adapter<MyAdapter.MainViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.MainViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.item_name,
            parent, false
        )

        return MainViewHolder(view)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val itemCurrent: housesWesteros = housesList[position]
        holder.nameHouse.text = itemCurrent.nome
        holder.situation.text = itemCurrent.situation
//        Glide.with(context)
//            .load(itemCurrent.imgH)
//            .into(holder.castle)
        Glide.with(context)
            .load(itemCurrent.urlImg)
            .into(holder.img)

        holder.itemView.setOnClickListener {
            val nameC = itemCurrent.nameHouse
            val imgC = itemCurrent.imgH
            val intent = Intent(context, secondActivity::class.java)
            intent.putExtra("name_c", nameC)
            intent.putExtra("img_h",imgC)
            context.startActivity(intent)
        }


    }

    override fun getItemCount(): Int {
        return housesList.size
    }

    inner class MainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


        val nameHouse: TextView = itemView.findViewById(R.id.txt_name)
        val situation: TextView = itemView.findViewById(R.id.txt_s)
        val img: ImageView = itemView.findViewById(R.id.image)
//
//        val nameCastle: TextView = itemView.findViewById(R.id.name_castle)
//        val castle: ImageView = itemView.findViewById(R.id.image_castle)
//        val a = itemView.setOnClickListener {
//            val txt_castle = nameCastle.text.toString()
//
//            val intent = Intent(context, secondActivity::class.java)
//            intent.putExtra("key",txt_castle)
//            context.startActivity(intent)
//        }


    }




}