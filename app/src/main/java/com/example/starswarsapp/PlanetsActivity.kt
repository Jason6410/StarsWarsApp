package com.example.starswarsapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.starswarsapp.adapter.PlanetsAdapter
import com.example.starswarsapp.databinding.ActivityPlanetsBinding
import com.example.starswarsapp.viewmodel.PlanetViewModel

class PlanetsActivity : AppCompatActivity() {

    private lateinit var binding:ActivityPlanetsBinding
    lateinit var planetsAdapter: PlanetsAdapter
    lateinit var viewModel: PlanetViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlanetsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        goToMain()
        initRecyclerView()
        initViewModel()

    }


    fun initRecyclerView(){
        binding.rvPlanets.apply {
            layoutManager = LinearLayoutManager(this@PlanetsActivity)
            val decoration = DividerItemDecoration(this@PlanetsActivity, DividerItemDecoration.VERTICAL)
            addItemDecoration(decoration)
            planetsAdapter = PlanetsAdapter()
            adapter = planetsAdapter

        }
    }

    fun initViewModel(){
        viewModel = ViewModelProvider(this).get(PlanetViewModel::class.java)
        viewModel.getPlanets()

        viewModel.progressBarDataObservable().observe(this, Observer {
            binding.progress.isVisible = it
        })

        viewModel.getPlanetListObservable().observe(this, Observer {
            if(it == null){
                Toast.makeText(this, "No result", Toast.LENGTH_SHORT).show()
            }
            else{
                planetsAdapter.planetList = it.results.toMutableList()
                planetsAdapter.notifyDataSetChanged()
            }
        })
    }

    private fun goToMain(){
        binding.btnBack.toolbar.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}