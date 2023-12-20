package com.example.pgkram

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pgkram.databinding.FragmentJobsBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.getValue

class Jobs : Fragment() {

    private lateinit var recyclerView1 : RecyclerView
    private lateinit var recyclerView2 : RecyclerView
    private lateinit var binding : FragmentJobsBinding
    private val jobList = mutableListOf<dataclassjobs>()
    val database = FirebaseDatabase.getInstance()
    val jobReference = database.getReference("JobsPosted")
    val featuredJobsReference = database.getReference("JobsPosted/Featured")
    val recommenedJobs = database.getReference("JobsPosted/Not_Featured")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_jobs, container, false)
        binding= FragmentJobsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView1 = binding.recycle1
        recyclerView1.layoutManager = LinearLayoutManager(context,
            LinearLayoutManager.HORIZONTAL,false)

        Log.d("JobAdapter1", "Fetching featured jobs from Firebase")

        recyclerView2 = binding.recycle2
        recyclerView2.layoutManager = LinearLayoutManager(context)
        featuredJobsReference.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                jobList.clear() // Clear existing data (optional)

                Log.d("JobAdapter2", "Fetching featured jobs from Firebase")

                if (snapshot.exists()){

                    for (jobSnapshot in snapshot.children) {
                        val job = jobSnapshot.getValue(dataclassjobs::class.java)// Handle null values

                        Log.d("JobAdapter3", "Fetching featured jobs from Firebase")
                        if (job != null) {
                            jobList.add(job)
                            Log.d("JobAdapter4", "Fetching featured jobs from Firebase")
                        }
                    }
                    // Initialize adapter with initial job list
                    recyclerView1.adapter = JobAdapter(jobList)
                    Log.d("JobAdapter5", "Fetching featured jobs from Firebase")

                }

            }

            override fun onCancelled(error: DatabaseError) {
                // Handle any errors during data retrieval

            }
        })

        recommenedJobs.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                jobList.clear() // Clear existing data (optional)

                Log.d("JobAdapter2", "Fetching featured jobs from Firebase")

                if (snapshot.exists()){

                    for (jobSnapshot in snapshot.children) {
                        val job = jobSnapshot.getValue(dataclassjobs::class.java)// Handle null values

                        Log.d("JobAdapter3", "Fetching featured jobs from Firebase")
                        if (job != null) {
                            jobList.add(job)
                            Log.d("JobAdapter4", "Fetching featured jobs from Firebase")
                        }
                    }
                    // Initialize adapter with initial job list
                    recyclerView2.adapter = JobAdapter2(jobList)
                    Log.d("JobAdapter5", "Fetching featured jobs from Firebase")

                }

            }

            override fun onCancelled(error: DatabaseError) {
                // Handle any errors during data retrieval

            }
        })
    }


}