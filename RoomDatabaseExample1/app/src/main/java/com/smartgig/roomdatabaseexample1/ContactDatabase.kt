package com.smartgig.roomdatabaseexample1

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Contact::class], version = 1, exportSchema = true)
abstract class ContactDatabase : RoomDatabase() {
    abstract fun contactDAO(): ContactDAO


    companion object {
        @Volatile
        private var INSTANCE: ContactDatabase? = null

//        fun getDatabase(context: Context): ContactDatabase {
//            if (INSTANCE == null) {
//                // Only one Instance will be created
//                synchronized(this) {
//                    INSTANCE = Room.databaseBuilder(
//                        context.applicationContext,
//                        ContactDatabase::class.java, "contactDB"
//                    ).build()
//                }
//
//            }
//            return INSTANCE!!
//        }

        fun getDatabase(context: Context): ContactDatabase {
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildDatabase(context).also { INSTANCE = it }

            }
        }

        private fun buildDatabase(context: Context): ContactDatabase {
            return Room.databaseBuilder(
                context,
                ContactDatabase::class.java,
                "contactDB"
            ).build()


        }
    }

}