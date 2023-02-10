package com.smartgig.viewmodelappsample1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

//    private var count: Int = 0
    lateinit var textCounter: TextView
    lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        mainViewModel = ViewModelProvider(this,MainViewModelFactory(10)).get(MainViewModel::class.java)
//        mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]
        textCounter = findViewById(R.id.counter_TV)

        setText()
    }


//    fun increment(view: View) {
//        count++
//        setText()
//
//    }

//    fun decrement(view: View) {
//        count--
//        setText()
//    }
//
//    fun reset(view: View) {
//        count = 0
//        setText()
//    }


    private fun setText() {
        textCounter.text = mainViewModel.count.toString()

    }

    fun increment(view: View) {
        mainViewModel.increment()
        setText()

    }

    fun decrement(view: View) {
        mainViewModel.decrement()
        setText()
    }

    fun reset(view: View) {
        mainViewModel.reset()
        setText()
    }




}