package com.example.pgkram

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.pgkram.databinding.ActivitySingleJobBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class SingleJob : AppCompatActivity() {

    private lateinit var binding : ActivitySingleJobBinding
    private var textArray: Array<String>? = null
    private var textArray2: Array<String>? = null
    private var buildString: StringBuilder = StringBuilder()
    private var buildString2: StringBuilder = StringBuilder()
    private val database = FirebaseDatabase.getInstance()
    private val failure = database.getReference("Success/Failure/11")
    private val success = database.getReference("Success/Success_data/11")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivitySingleJobBinding.inflate(layoutInflater)
        setContentView(binding.root)

        failure.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val currentValue = dataSnapshot.getValue(Int::class.java)!!
                val newValue = currentValue+ 1 // Replace "yourCondition" with your logic for adding or removing
                failure.setValue(newValue)
            }

            override fun onCancelled(error: DatabaseError) {
                // Handle errors
            }
        })

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

        binding.apply.setOnClickListener {
                failure.addListenerForSingleValueEvent(object : ValueEventListener {
                    override fun onDataChange(dataSnapshot: DataSnapshot) {
                        val currentValue = dataSnapshot.getValue(Int::class.java)!!
                        val newValue = currentValue - 1 // Replace "yourCondition" with your logic for adding or removing
                        failure.setValue(newValue)
                        Log.d("J1", "$newValue")
                    }

                    override fun onCancelled(error: DatabaseError) {
                        // Handle errors
                    }
                })
            success.addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    val currentValue = dataSnapshot.getValue(Int::class.java)!!
                    val newValue = currentValue+ 1 // Replace "yourCondition" with your logic for adding or removing
                    success.setValue(newValue)
                    Log.d("J1", "$newValue")
                }

                override fun onCancelled(error: DatabaseError) {
                    // Handle errors
                }
            })

        }

    }
}