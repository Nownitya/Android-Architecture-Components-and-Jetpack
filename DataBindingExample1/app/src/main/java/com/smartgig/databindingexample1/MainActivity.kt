package com.smartgig.databindingexample1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.smartgig.databindingexample1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
//        setContentView(R.layout.activity_main)

//        val quoteTV = findViewById<TextView>(R.id.quotesTV)
//        val authorTV = findViewById<TextView>(R.id.author_nameTV)
//        quoteTV.text = "If one way be better than another, that you may be sure is natures way."
//        authorTV.text = "Aristotle"

        val quoteOBJ =Quote("If one way be better than another, that you may be sure is natures way.","Aristotle")

        binding.quote = quoteOBJ




    }
}