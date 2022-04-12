package com.example.starswarsapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.starswarsapp.data.RetrofitInstance
import com.example.starswarsapp.data.StarWarsService
import com.example.starswarsapp.model.PeopleList
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PeopleViewModel: ViewModel() {

    var recyclerPeopleData: MutableLiveData<PeopleList> = MutableLiveData()
    var progressBarData: MutableLiveData<Boolean> = MutableLiveData<Boolean>()

    fun getPeopleListObservable(): MutableLiveData<PeopleList> = recyclerPeopleData
    fun progressBarDataObservable(): MutableLiveData<Boolean> = progressBarData

    fun getPeople(){
        val retroInstance = RetrofitInstance.getRetrofitInstance().create(StarWarsService::class.java)
        val call = retroInstance.getPeople()
        call.enqueue(object : Callback<PeopleList> {
            override fun onResponse(call: Call<PeopleList>, response: Response<PeopleList>) {
                if(response.isSuccessful){
                    progressBarData.postValue(false)
                    recyclerPeopleData.postValue(response.body())
                }
                else{
                    progressBarData.postValue(true)
                    recyclerPeopleData.postValue(null)
                }
            }

            override fun onFailure(call: Call<PeopleList>, t: Throwable) {
                recyclerPeopleData.postValue(null)
            }
        })
    }

}