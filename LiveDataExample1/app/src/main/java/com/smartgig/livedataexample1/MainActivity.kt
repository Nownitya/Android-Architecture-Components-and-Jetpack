package com.smartgig.livedataexample1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    lateinit var mainViewModel: MainViewModel

    private val factsTV: TextView
        get() = findViewById(R.id.factsTV)

    private val updateBt: Button
        get() = findViewById(R.id.updateBT)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]

        mainViewModel.factsLiveData.observe(this, Observer {

            factsTV.text = it
        })

        updateBt.setOnClickListener {
            mainViewModel.updateLiveData()
        }
    }
}