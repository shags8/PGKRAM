package com.example.pgkram

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.google.firebase.Firebase
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.analytics

class StartPage : AppCompatActivity() {

    private lateinit var analytics: FirebaseAnalytics
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start_page)

        analytics = Firebase.analytics

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