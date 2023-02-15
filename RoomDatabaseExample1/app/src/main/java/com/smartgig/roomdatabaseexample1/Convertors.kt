package com.smartgig.roomdatabaseexample1

import androidx.room.TypeConverter
import androidx.room.TypeConverters
import java.util.*

class Convertors {

    @TypeConverter
    fun fromDateToLong(value: Date): Long {
        return value.time
    }
    @TypeConverter
    fun fromLongToDate(value: Long): Date {
        return Date(value)

    }

//    @TypeConverter
//    fun fromLongToDate(value: Long?): Date? {
//        return value?.let { Date(it) }
//    }
//
//    @TypeConverter
//    fun dateToTimestamp(date: Date?): Long? {
//        return date?.time?.toLong()
//    }
}