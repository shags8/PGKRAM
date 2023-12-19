package com.example.pgkram

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.pgkram.databinding.ActivityBottomBinding

class Bottom : AppCompatActivity() {

    private lateinit var binding : ActivityBottomBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityBottomBinding.inflate(layoutInflater)
        setContentView(binding.root)

            replaceFragments(Jobs())

            binding.bottom.setOnItemSelectedListener { item ->
                when (item.itemId) {
                    R.id.jobs -> {
                        replaceFragments(Jobs())}
                    R.id.notifications ->{
                        replaceFragments(Notifications())}
                    R.id.chats -> {
                        replaceFragments(Messages())}
                    R.id.profile -> {
                        replaceFragments(Profile())}
                }
                true
            }

        }
    fun replaceFragments(fragment: Fragment)
    {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout,fragment)
        fragmentTransaction.commit()
    }

    }

