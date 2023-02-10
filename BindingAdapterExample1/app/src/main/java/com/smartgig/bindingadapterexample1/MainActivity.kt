package com.smartgig.bindingadapterexample1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.smartgig.bindingadapterexample1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
//        setContentView(R.layout.activity_main)

        val post = Post("Intoducting to Kotlin",
        "Code",
        "https://ia800208.us.archive.org/14/items/HSF-photo-iss011e12401/iss011e12401.jpg")

        binding.post =post


    }
}