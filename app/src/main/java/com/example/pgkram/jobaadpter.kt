package com.example.pgkram

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class JobAdapter(private val jobList: MutableList<dataclassjobs>) : RecyclerView.Adapter<JobAdapter.JobViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JobViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.jobdesign,parent,false)
        return JobAdapter.JobViewHolder(itemView)
        Log.d("JobAdapter5", "Fetching featured jobs from Firebase")
    }

    override fun onBindViewHolder(holder: JobViewHolder, position: Int) {
        val job = jobList[position]

        holder.jobTitleTextView.text = job.job_title
        holder.description.text = job.about
        Log.d("JobAdapter6", "Fetching featured jobs from Firebase")

    }

    override fun getItemCount(): Int {
        return jobList.size
    }


    class JobViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val jobTitleTextView: TextView = itemView.findViewById(R.id.jobtitle)
        val description: TextView = itemView.findViewById(R.id.description)
    }

}

