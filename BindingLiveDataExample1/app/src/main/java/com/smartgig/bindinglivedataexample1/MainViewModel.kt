package com.smartgig.bindinglivedataexample1

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    val quoteLiveData = MutableLiveData("I will prepare and some day my chance will come.")

    fun updateQuote() {
        quoteLiveData.value = "It is not in the stars to hold our destiny but in ourselves."
    }

}