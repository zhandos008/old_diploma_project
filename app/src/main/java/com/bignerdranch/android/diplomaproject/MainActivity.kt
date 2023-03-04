package com.bignerdranch.android.diplomaproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.graphics.rotationMatrix
import com.bignerdranch.android.diplomaproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.signIn.setOnClickListener {
            intent = Intent(this, SignIn::class.java)
            startActivity(intent)
        }

        binding.signUp.setOnClickListener {
            intent = Intent(this, SignUp::class.java)
            startActivity(intent)
        }

        binding.guest.setOnClickListener {
            intent = Intent(this, MainPageActivity::class.java)
            startActivity(intent)
        }
    }
}