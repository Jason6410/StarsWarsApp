package com.example.starswarsapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.starswarsapp.data.RetrofitInstance
import com.example.starswarsapp.data.StarWarsService
import com.example.starswarsapp.model.PlanetList
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PlanetViewModel: ViewModel() {

    var recyclerPlanetData: MutableLiveData<PlanetList> = MutableLiveData()
    var progressBarData: MutableLiveData<Boolean> = MutableLiveData<Boolean>()

    fun getPlanetListObservable(): MutableLiveData<PlanetList> = recyclerPlanetData
    fun progressBarDataObservable(): MutableLiveData<Boolean> = progressBarData

    fun getPlanets(){
        val retroInstance = RetrofitInstance.getRetrofitInstance().create(StarWarsService::class.java)
        val call = retroInstance.getPlanets()
        call.enqueue(object : Callback<PlanetList>{
            override fun onResponse(call: Call<PlanetList>, response: Response<PlanetList>) {
                if(response.isSuccessful){
                    progressBarData.postValue(false)
                    recyclerPlanetData.postValue(response.body())
                }
                else{
                    progressBarData.postValue(true)
                    recyclerPlanetData.postValue(null)
                }
            }

            override fun onFailure(call: Call<PlanetList>, t: Throwable) {
                recyclerPlanetData.postValue(null)
            }
        })
    }
}