package com.example.starswarsapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.starswarsapp.R
import com.example.starswarsapp.databinding.ItemPeopleBinding
import com.example.starswarsapp.model.People


class PeopleAdapter: RecyclerView.Adapter<PeopleAdapter.ViewHolderPeople>() {

    var peopleList = mutableListOf<People>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderPeople {
        val inflater = LayoutInflater.from(parent.context).inflate(R.layout.item_people, parent, false)
        return ViewHolderPeople(inflater)
    }

    override fun onBindViewHolder(holder: ViewHolderPeople, position: Int) {
        holder.bind(peopleList[position])
    }

    override fun getItemCount(): Int {
        return peopleList.size
    }

    class ViewHolderPeople(view: View): RecyclerView.ViewHolder(view){
        val binding = ItemPeopleBinding.bind(view)

        val namePeople = binding.tvNamePeople
        val heightPeople = binding.tvHeightPeople
        val genderPeople = binding.tvGenderPeople
        val hairColorPeople = binding.tvHairColorPeople
        val skinColorPeople = binding.tvSkinColorPeople

        fun bind(data: People){
            namePeople.text = data.name
            heightPeople.text = data.height
            genderPeople.text = data.gender
            hairColorPeople.text = data.hair_color
            skinColorPeople.text = data.skin_color
        }
    }
}