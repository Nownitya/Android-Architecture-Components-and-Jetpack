package com.smartgig.roomdatabaseexample1

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.Date

class MainActivity : AppCompatActivity() {

    lateinit var database: ContactDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        database = ContactDatabase.getDatabase(this)
//        val database2 = ContactDatabase.getDatabase(this)

//        database = Room.databaseBuilder(
//            applicationContext,
//            ContactDatabase::class.java, "contactDB"
//        ).build()

        GlobalScope.launch {
            database.contactDAO().insertContact(Contact(0, "Rohan", "9494949494",Date(),1))
        }

    }

    fun getData(view: View) {
        database.contactDAO().getContact().observe(this, Observer {
            Log.d("CheckData",it.toString())
        })

//        database.contactDAO().getContact().observe(this) {
//            Log.d("CheckData", it.toString())
//        }

    }
}