package com.example.starswarsapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.starswarsapp.R
import com.example.starswarsapp.databinding.ItemPlanetsBinding
import com.example.starswarsapp.model.Planet

class PlanetsAdapter: RecyclerView.Adapter<PlanetsAdapter.ViewHolderPlanets>() {

    var planetList = mutableListOf<Planet>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlanetsAdapter.ViewHolderPlanets {
        val inflater = LayoutInflater.from(parent.context).inflate(R.layout.item_planets, parent, false)
        return ViewHolderPlanets(inflater)
    }

    override fun onBindViewHolder(holder: PlanetsAdapter.ViewHolderPlanets, position: Int) {
        holder.bind(planetList[position])
    }

    override fun getItemCount(): Int {
        return planetList.size
    }

    class ViewHolderPlanets(view: View): RecyclerView.ViewHolder(view){
        val binding = ItemPlanetsBinding.bind(view)

        val namePlanet = binding.tvNamePlanet
        val climatePlanet = binding.tvClimatePlanet
        val populationPlanet = binding.tvPopulationPlanet

        fun bind(data: Planet){
            namePlanet.text = data.name
            climatePlanet.text = data.climate
            populationPlanet.text = data.population
        }
    }
}