package com.smartgig.roomdatabaseexample1

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import java.util.Objects

@Database(entities = [Contact::class], version = 2)
@TypeConverters(Convertors::class)
abstract class ContactDatabase : RoomDatabase() {
    abstract fun contactDAO(): ContactDAO


    companion object {

        val migration_1_2 = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("ALTER TABLE contact ADD COLUMN isActive INTEGER NOT NULL DEFAULT(1)")

            }

        }
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
            ).addMigrations(migration_1_2)
                .build()
        }
    }

}