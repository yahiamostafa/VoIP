    package com.yahia.voip

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView

    class VideoPlayer : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_player)

        // init the player and add it to the lifecycle
        val youTubePlayerView: YouTubePlayerView = findViewById(R.id.youtube_player_view);
        lifecycle.addObserver(youTubePlayerView);

        // get the intent and the passed value
        val videoID : String? = intent.getStringExtra("VideoID")

        val videoLink = videoID?.split("/")?.toTypedArray()

        youTubePlayerView.addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
            override fun onReady(youTubePlayer: YouTubePlayer) {
                youTubePlayer.loadVideo(videoLink!!.last().toString() ,  0f);
            }
        })
    }
}
