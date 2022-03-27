package com.dara.movieapp

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.airbnb.lottie.LottieAnimationView
import com.dara.movieapp.adapter.SuperHeroAdapter
import com.dara.movieapp.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private var i : Int = 0
    private lateinit var  binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initRecyclerView()

        binding.buttonPasarPagina.setOnClickListener{
            checkValue()
        }

        var like = false

        binding.likeImageView.setOnClickListener{
            like = likeAnimation(binding.likeImageView, R.raw.bandai_dokkan, like)
        }

        var like2 = false

        binding.likeImageView2.setOnClickListener {
            like2 = likeAnimation(binding.likeImageView2, R.raw.hmm, like2)
        }

        var likeimage = false

        binding.imageViewMovie.setOnClickListener{
            i++

                if(i==1){
                    Toast.makeText(this@MainActivity, "Un click para ver detalles de peli", Toast.LENGTH_SHORT).show()
                }else if (i==2){
                    Toast.makeText(this@MainActivity, "Doble click para dar like", Toast.LENGTH_SHORT).show()
                    likeimage = likeAnimationImage(binding.imageViewMovie, R.raw.hmm, likeimage)
                }
                i=0
            }



    }
    private fun likeAnimation(imageView: LottieAnimationView, animation: Int, likeIcon: Boolean):Boolean{

        if (!likeIcon){
            imageView.setAnimation(animation)
            imageView.playAnimation()
            println(likeIcon)
        }else {
            imageView.animate()
                .alpha(0f)
                .setDuration(500)
                .setListener(object : AnimatorListenerAdapter(){
                    override fun onAnimationEnd(animator: Animator){
                        imageView.setImageResource(R.drawable.twitter_like)
                        imageView.alpha = 1f
                    }
                })
        }
        return !likeIcon
    }

    private fun likeAnimationImage(
        imageViewMovie: LottieAnimationView,
        animation: Int,
        likeimage: Boolean
    ):Boolean{


        if (!likeimage){
           imageViewMovie.setAnimation(animation)
            imageViewMovie.playAnimation()
        }


        return !likeimage

    }

    fun checkValue(){
        val intent = Intent(this, DetailsActivity::class.java)
        startActivity(intent)
    }

    private fun initRecyclerView(){
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerSuperHero)
        //val recyclerView = binding.recyclerSuperHero
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = SuperHeroAdapter(SuperHeroProvider.superheroList)
    }

}