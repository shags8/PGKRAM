package com.example.pgkram

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class StartPage : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start_page)

        var imageview1 = findViewById<ImageView>(R.id.imageView6)
        var imageview2 = findViewById<ImageView>(R.id.imageView7)
        imageview1.setOnClickListener {
            val intent = Intent(this , MainActivity::class.java)
            startActivity(intent)
        }
        imageview2.setOnClickListener {
            val intent = Intent(this , Bottom::class.java)
            startActivity(intent)
            finish()
        }
    }
}