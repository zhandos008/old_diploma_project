package com.bignerdranch.android.diplomaproject.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.bignerdranch.android.diplomaproject.Document

@Database(entities = [Document::class], version = 1)
abstract class DocumentDataBase: RoomDatabase() {
    abstract fun documentDao(): DocumentDao
}