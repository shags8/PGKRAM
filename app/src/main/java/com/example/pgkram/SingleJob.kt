package com.example.pgkram

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pgkram.databinding.ActivitySingleJobBinding
import com.google.firebase.database.FirebaseDatabase

class SingleJob : AppCompatActivity() {

    private lateinit var binding : ActivitySingleJobBinding
    private var textArray: Array<String>? = null
    private var textArray2: Array<String>? = null
    private var buildString: StringBuilder = StringBuilder()
    private var buildString2: StringBuilder = StringBuilder()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivitySingleJobBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var jobtitle = binding.title
        var name = binding.name
        val subtitle2 = binding.subtitle
        val about2 = binding.about
        val responsiblities = binding.description
        val requirements = binding.requirements


        val requirement = intent.getStringExtra("requirement") ?: ""
        val responsibility = intent.getStringExtra("responsibility") ?: ""
        val subtitle = intent.getStringExtra("subtitle") ?: ""
        val about = intent.getStringExtra("about") ?: ""
        val jobTitle = intent.getStringExtra("jobtitle") ?: ""
        val company = intent.getStringExtra("company") ?: ""


        jobtitle.text = jobTitle
        name.text = company
        subtitle2.text = subtitle
        about2.text = about
        responsiblities.text = responsibility
        requirements.text = requirement

    }
}