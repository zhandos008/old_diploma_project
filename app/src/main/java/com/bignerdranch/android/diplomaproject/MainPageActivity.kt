package com.bignerdranch.android.diplomaproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bignerdranch.android.diplomaproject.databinding.ActivityMainPageBinding
import java.util.*

class MainPageActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainPageBinding




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainPageBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}