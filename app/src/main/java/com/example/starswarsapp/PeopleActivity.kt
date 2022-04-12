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
import com.example.starswarsapp.adapter.PeopleAdapter
import com.example.starswarsapp.databinding.ActivityPeopleBinding
import com.example.starswarsapp.viewmodel.PeopleViewModel

class PeopleActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPeopleBinding
    lateinit var peopleAdapter: PeopleAdapter
    lateinit var viewModel: PeopleViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPeopleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        goToMain()
        initRecyclerView()
        initViewModel()

    }

    private fun initRecyclerView(){
        binding.rvPeople.apply {
            layoutManager = LinearLayoutManager(this@PeopleActivity)
            val decoration = DividerItemDecoration(this@PeopleActivity, DividerItemDecoration.VERTICAL)
            addItemDecoration(decoration)
            peopleAdapter = PeopleAdapter()
            adapter = peopleAdapter

        }
    }

    private fun initViewModel(){
        viewModel = ViewModelProvider(this).get(PeopleViewModel::class.java)

        viewModel.getPeople()

        viewModel.progressBarDataObservable().observe(this, Observer {
            binding.progress.isVisible = it
        })

        viewModel.getPeopleListObservable().observe(this, Observer {
            if(it == null){
                Toast.makeText(this, "No result", Toast.LENGTH_SHORT).show()
            }
            else{
                peopleAdapter.peopleList = it.results.toMutableList()
                peopleAdapter.notifyDataSetChanged()
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