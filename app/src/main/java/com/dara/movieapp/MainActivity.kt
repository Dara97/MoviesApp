package com.dara.movieapp

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import com.airbnb.lottie.LottieAnimationView
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private var i : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var like = false

        likeImageView.setOnClickListener{
            like = likeAnimation(likeImageView, R.raw.bandai_dokkan, like)
        }

        var like2 = false

        likeImageView2.setOnClickListener {
            like2 = likeAnimation(likeImageView2, R.raw.hmm, like2)
        }

        var likeimage = false

        imageViewMovie.setOnClickListener{
            i++
            val handler = Handler()

            handler.postDelayed({
                if(i==1){
                    Toast.makeText(this@MainActivity, "Un click para ver detalles de peli", Toast.LENGTH_SHORT).show()
                }else if (i==2){
                    Toast.makeText(this@MainActivity, "Doble click para dar like", Toast.LENGTH_SHORT).show()
                    likeimage = likeAnimationImage(imageViewMovie, R.raw.hmm, likeimage)
                }
                i=0
            },500)

        }

    }
    private fun likeAnimation(imageView: LottieAnimationView, animation: Int, like: Boolean):Boolean{

        if (!like){
            imageView.setAnimation(animation)
            imageView.playAnimation()
            println(like)
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
        return !like
    }

    private fun likeAnimationImage(
        imageViewMovie: LottieAnimationView,
        animation: Int,
        likeimage: Boolean
    ):Boolean{


        if (!likeimage){
           imageViewMovie.setAnimation(animation)
            imageViewMovie.playAnimation()
            imageViewMovie.setImageResource(R.drawable.spider)

        }


        return !likeimage

    }

}