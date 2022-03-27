package com.dara.movieapp.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dara.movieapp.R
import com.dara.movieapp.SuperHero

class SuperHeroViewHolder (view:View):RecyclerView.ViewHolder(view){

    val superHero = view.findViewById<TextView>(R.id.tvMovieName)
    val realName = view.findViewById<TextView>(R.id.tvRealName)
    val publisher = view.findViewById<TextView>(R.id.tvPublisher)
    val photo = view.findViewById<ImageView>(R.id.ivMovie)

    fun render (superHeroModel: SuperHero){
        superHero.text=superHeroModel.superhero
        realName.text=superHeroModel.realName
        publisher.text=superHeroModel.publisher
    }

}