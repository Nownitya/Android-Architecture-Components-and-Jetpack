package com.smartgig.lifiecycleaware

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lifecycle.addObserver(Observer())
        Log.d("LIFECYCLE","Activity: onCreate")
    }

    override fun onStart() {
        super.onStart()
        Log.d("LIFECYCLE","Activity: onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("LIFECYCLE","Activity: onResume")

    }

    override fun onPause() {
        super.onPause()
        Log.d("LIFECYCLE","Activity: onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("LIFECYCLE","Activity: onStop")

    }

    override fun onRestart() {
        super.onRestart()
        Log.d("LIFECYCLE","Activity: onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("LIFECYCLE","Activity: onDestroy")
    }

}