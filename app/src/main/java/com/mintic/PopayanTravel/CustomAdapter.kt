package com.mintic.PopayanTravel

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class CustomAdapter(private var context: MainActivity,
                    private var cityName: ArrayList<String>,
                    private var cityOverview: ArrayList<String>,
                    private var cityScore: ArrayList<String>,
                    private var cityImage: ArrayList<String>,
                    private var cityDescription: ArrayList<String>
                    ): RecyclerView.Adapter<CustomAdapter.MyViewHolder>(){

    val intent: Intent = Intent(context, SiteDetailActivity::class.java)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.row2, parent, false)
        return MyViewHolder(v)
    }

    inner class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var image: ImageView = itemView.findViewById<View>(R.id.itemImage) as ImageView
        var name: TextView = itemView.findViewById<View>(R.id.tvName) as TextView
        var overview: TextView = itemView.findViewById<View>(R.id.tvOverview) as TextView
        var score: TextView = itemView.findViewById<View>(R.id.tvScore) as TextView
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.name.text = cityName[position]
        holder.overview.text = cityOverview[position]
        holder.score.text = cityScore[position]

        Glide.with(context).load(cityImage[position]).into(holder.image)

        holder.itemView.setOnClickListener {
            context.startActivity(intent
                .apply {
                    putExtra("keyName",cityName[position])
                    putExtra("keyImage",cityImage[position])
                    putExtra("keyDescription",cityDescription[position])
                })
        }
    }

    override fun getItemCount(): Int {
        return cityName.size
    }
}