package com.mintic.PopayanTravel

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class SiteDetailActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_site_detail)

        var tvDescript: TextView = findViewById(R.id.tvDescription)
        var ivPhoto: ImageView = findViewById(R.id.imageView2)

        Glide.with(this).load(intent.getStringExtra("keyImage")).into(ivPhoto)
        tvDescript.setText(intent.getStringExtra("keyDescription"))
        setTitle(intent.getStringExtra("keyName"))
    }
}