package com.smartgig.bindinglivedataexample1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.smartgig.bindinglivedataexample1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var mainViewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= DataBindingUtil.setContentView(this, R.layout.activity_main)
//        setContentView(R.layout.activity_main)
        mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]

        binding.lifecycleOwner = this
//        mainViewModel.quoteLiveData.observe(this, Observer {
//            binding.quoteTV.text = it
//        })


        binding.mainViewModel = mainViewModel
//        binding.updateBT.setOnClickListener {
//            mainViewModel.updateQuote()
//        }


    }
}