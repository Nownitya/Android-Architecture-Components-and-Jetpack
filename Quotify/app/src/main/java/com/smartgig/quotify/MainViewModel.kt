package com.smartgig.quotify

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import java.nio.charset.Charset

class MainViewModel(val context: Context) : ViewModel() {

    private var quoteList: Array<Quote> = emptyArray()
    var index = 0

    init {
        quoteList=loadQuotesFromAssets()
    }

    private fun loadQuotesFromAssets(): Array<Quote> {

        val inputStream = context.assets.open("quotes.json")
        val size: Int = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        val json = String(buffer, Charsets.UTF_8)
        val gson = Gson()

        return gson.fromJson(json, Array<Quote>::class.java)

    }

    fun getQuote() = quoteList[index]

    fun nextQuote() = quoteList[++index]

    fun previousQuote() =quoteList[--index]

    fun currentIndex() = index.toInt()

//    fun currentIndex() =


}