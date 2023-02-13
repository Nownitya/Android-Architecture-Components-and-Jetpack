package com.smartgig.roomdatabaseexample1

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Contact::class], version = 1, exportSchema = true)
abstract class ContactDatabase : RoomDatabase() {
    abstract fun contactDAO(): ContactDAO


}