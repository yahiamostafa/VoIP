package com.yahia.voip

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView
import java.lang.Exception


class Video : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video)

        val youTubePlayerView:YouTubePlayerView = findViewById(R.id.youtube_player_view);
        lifecycle.addObserver(youTubePlayerView);

        val videoLink = findViewById<EditText>(R.id.videoTxt);

        val getBtn = findViewById<Button>(R.id.getBtn);

        getBtn.setOnClickListener {
            youTubePlayerView.addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
                override fun onReady(youTubePlayer: YouTubePlayer) {
                    val videoId = videoLink.text.toString();

                    try {
                        youTubePlayer.loadVideo(videoId, 0f)
                    }catch (e:Exception)
                    {
                        Toast.makeText(this@Video , e.message , Toast.LENGTH_SHORT )
                    }

                }
            })
        }


    }
}