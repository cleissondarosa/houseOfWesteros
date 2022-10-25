package com.example.houseofdragon

import android.content.Context
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class secondActivity : AppCompatActivity() {
    private lateinit var txt_castle: TextView
    private lateinit var imgCastle: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        txt_castle = findViewById(R.id.name_castle)
        imgCastle = findViewById(R.id.image_castle)

        val houseIntent = intent
        val nameHouseA = houseIntent.getStringExtra("name_c")
        val img_house = houseIntent.getStringExtra("img_h")

        txt_castle.text = nameHouseA
        imgCastle.loadImage(img_house, getProgessDrawable(this))
    }

    fun getProgessDrawable(c: Context): CircularProgressDrawable {
        return CircularProgressDrawable(c).apply {
        }

    }

    fun ImageView.loadImage(uri: String?, progressDawable: CircularProgressDrawable) {

        val option = RequestOptions().placeholder(progressDawable)
            .error(R.drawable.not_found)

        Glide.with(context)
            .setDefaultRequestOptions(option)
            .load(uri)
            .into(this)

    }


}