package com.smartgig.livedataexample1

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private val factsLiveDataObject = MutableLiveData<String>("This is a Fact")

    val factsLiveData: LiveData<String>
        get() = factsLiveDataObject



    fun updateLiveData(){
        factsLiveDataObject.value = "Another Fact"

    }
}