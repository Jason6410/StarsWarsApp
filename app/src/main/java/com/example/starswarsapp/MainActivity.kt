package com.example.starswarsapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.starswarsapp.databinding.ActivityMainBinding
import com.example.starswarsapp.databinding.ActivityPlanetsBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.llPlanet.setOnClickListener {
            goToPlanets()
        }

        binding.llPeople.setOnClickListener {
            goToPeople()
        }

    }

    private fun goToPeople() {
        val intent = Intent(this, PeopleActivity::class.java)
        startActivity(intent)
    }

    private fun goToPlanets() {
        val intent = Intent(this, PlanetsActivity::class.java)
        startActivity(intent)
    }
}