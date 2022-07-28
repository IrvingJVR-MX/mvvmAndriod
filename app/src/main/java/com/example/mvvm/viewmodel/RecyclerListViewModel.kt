package com.example.mvvm.viewmodel

import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvm.models.RecyclerList
import com.example.mvvm.network.RetroInstance
import com.example.mvvm.network.RetroService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RecyclerListViewModel: ViewModel() {
    var recyclerListLiveData : MutableLiveData<ArrayList<RecyclerList>> = MutableLiveData()
    lateinit var response: ArrayList<RecyclerList>
    fun getRecyclerListObserver(): MutableLiveData<ArrayList<RecyclerList>>{
        return recyclerListLiveData
    }

    fun makeApiCall() {
        viewModelScope.launch (Dispatchers.IO){
            val retroInstance = RetroInstance.getRetroInstance().create(RetroService::class.java)
            response = retroInstance.getDataFromApiJson()
            recyclerListLiveData.postValue(response)
        }
    }
    fun sortById (){
        response.sortByDescending { it.id}
        recyclerListLiveData.postValue(response)
    }

    fun validateUserData(
        RecyclerList : RecyclerList
    ): Boolean {
        return true
    }

}