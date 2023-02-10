package com.smartgig.viewmodelappsample1

import androidx.lifecycle.ViewModel

class MainViewModel(initialValue: Int) : ViewModel() {

//    var count: Int = 0
    var count: Int = initialValue

    fun increment() {
        count++
    }

    fun decrement() {
        count--
    }

    fun reset() {
        count = 0
    }

}