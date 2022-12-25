package com.yahia.voip

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class Video : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video)



        val videoLink = findViewById<EditText>(R.id.videoTxt);

        val getBtn = findViewById<Button>(R.id.getBtn);

        getBtn.setOnClickListener {

            intent = Intent(this@Video , VideoPlayer::class.java)
            intent.putExtra("VideoID" , videoLink.text.toString())
            startActivity(intent)
        }


    }
}