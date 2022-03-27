package com.dara.movieapp.adapter

import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dara.movieapp.SuperHero
import com.dara.movieapp.databinding.ItemMoviesBinding

class SuperHeroViewHolder (view:View):RecyclerView.ViewHolder(view){

    val binding = ItemMoviesBinding.bind(view)

    fun render (superHeroModel: SuperHero , onClickListener:(SuperHero)-> Unit){
        binding.tvMovieName.text=superHeroModel.superhero
        binding.tvRealName.text=superHeroModel.realName
        binding.tvPublisher.text=superHeroModel.publisher
        Glide.with(binding.ivMovie.context).load(superHeroModel.photo).into(binding.ivMovie)

        itemView.setOnClickListener{
            onClickListener(superHeroModel)
        }
    }

}