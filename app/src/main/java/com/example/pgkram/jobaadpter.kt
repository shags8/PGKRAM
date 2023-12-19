package com.example.pgkram

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import org.checkerframework.checker.units.qual.C

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
        val array = job.requirement
        val array2 = job.responsibility
        var descriptionText = StringBuilder()
        var descriptionText2 = StringBuilder()
        if (array2 != null) {
            for (item in array2){
                descriptionText2.append("• $item\n")
            }
        }
        else {
            // Handle the case where description is missing or not an array (optional):
            descriptionText2 = descriptionText2.append("No description available")
        }
        if (array != null) {
            for (item in array){
                descriptionText.append("• $item\n")
            }
        }
        else {
            // Handle the case where description is missing or not an array (optional):
            descriptionText = descriptionText.append("No description available")
        }
        Log.d("JobAdapter6", "Fetching featured jobs from Firebase")
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, SingleJob::class.java)
            intent.putExtra("requirement", descriptionText.toString())
            intent.putExtra("responsibility", descriptionText2.toString())
            intent.putExtra("subtitle", job.subtitle)
            intent.putExtra("about", job.about)
            intent.putExtra("jobtitle", job.job_title)
            intent.putExtra("company", job.company)
            holder.itemView.context.startActivity(intent)


        }

    }

    override fun getItemCount(): Int {
        return jobList.size
    }


    class JobViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val jobTitleTextView: TextView = itemView.findViewById(R.id.jobtitle)
        val description: TextView = itemView.findViewById(R.id.description)
    }

}

class JobAdapter2(private val jobList: MutableList<dataclassjobs>) : RecyclerView.Adapter<JobAdapter2.JobViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JobViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.jobdesign2,parent,false)
        return JobAdapter2.JobViewHolder(itemView)
        Log.d("JobAdapter5", "Fetching featured jobs from Firebase")
    }

    override fun onBindViewHolder(holder: JobViewHolder, position: Int) {
        val job = jobList[position]

        holder.jobTitleTextView.text = job.job_title
        holder.description.text = job.about
        val array = job.requirement
        val array2 = job.responsibility
        var descriptionText = StringBuilder()
        var descriptionText2 = StringBuilder()
        if (array2 != null) {
            for (item in array2){
                descriptionText2.append("• $item\n")
            }
        }
        else {
            // Handle the case where description is missing or not an array (optional):
            descriptionText2 = descriptionText2.append("No description available")
        }
        if (array != null) {
            for (item in array){
                descriptionText.append("• $item\n")
            }
        }
        else {
            // Handle the case where description is missing or not an array (optional):
            descriptionText = descriptionText.append("No description available")
        }
        Log.d("JobAdapter6", "Fetching featured jobs from Firebase")
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, SingleJob::class.java)
            intent.putExtra("requirement", descriptionText.toString())
            intent.putExtra("responsibility", descriptionText2.toString())
            intent.putExtra("subtitle", job.subtitle)
            intent.putExtra("about", job.about)
            intent.putExtra("jobtitle", job.job_title)
            intent.putExtra("company", job.company)
            holder.itemView.context.startActivity(intent)


        }

    }

    override fun getItemCount(): Int {
        return jobList.size
    }


    class JobViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val jobTitleTextView: TextView = itemView.findViewById(R.id.jobtitle)
        val description: TextView = itemView.findViewById(R.id.description)
    }

}

