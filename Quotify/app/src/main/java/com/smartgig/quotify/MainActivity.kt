package com.smartgig.quotify

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    lateinit var mainViewModel: MainViewModel
    private val quoteText :TextView
        get() = findViewById(R.id.quotesTV)

    private val quoteAuthor: TextView
    get() = findViewById(R.id.author_nameTV)

    private val previousBT :TextView
        get() = findViewById(R.id.onPrevious_BT)

    private val nextBT :TextView
        get() = findViewById(R.id.onNext_BT)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel = ViewModelProvider(
            this,
            MainViewModelFactory(application)
        ).get(MainViewModel::class.java)

        setQuote(mainViewModel.getQuote())

        previousBT.setOnClickListener { onPrevious() }
        nextBT.setOnClickListener { onNext() }
    }

    private fun setQuote(quote: Quote) {
        quoteText.text = quote.text
        quoteAuthor.text = quote.author
    }

    fun onShare(view: View) {
        val intent = Intent(Intent.ACTION_SEND)
//        intent.setType("text/plain")
        intent.type = "text/plain"
        intent.putExtra(Intent.EXTRA_TEXT, mainViewModel.getQuote().text)
        startActivity(intent)

    }
    fun onPrevious() {

//        val curIndex = mainViewModel.index
        val curIndex = mainViewModel.currentIndex()-1
        Toast.makeText(this, "Index:$curIndex", Toast.LENGTH_SHORT).show()
        if (curIndex <= 0) {

            previousBT.visibility = View.INVISIBLE
            previousBT.isClickable = false
            setQuote(mainViewModel.previousQuote())
//            try {
//
//            } catch (e: java.lang.Exception) {
//
//            }
            Toast.makeText(this, "Index:$curIndex", Toast.LENGTH_SHORT).show()
        } else if (curIndex >= 1) {
            previousBT.visibility = View.VISIBLE
            previousBT.isClickable = true
            setQuote(mainViewModel.previousQuote())
            Toast.makeText(this, "Index:$curIndex", Toast.LENGTH_SHORT).show()
        }




    }
    fun onNext() {
        setQuote(mainViewModel.nextQuote())
        val curIndex = mainViewModel.currentIndex()
        Toast.makeText(this, "Index:$curIndex", Toast.LENGTH_SHORT).show()

        if (curIndex >= 1) {

            previousBT.visibility = View.VISIBLE
            previousBT.isClickable = true


        }
//        else if (curIndex-1 <=1) {
//            previousBT.visibility = View.GONE
//        }
    }
}