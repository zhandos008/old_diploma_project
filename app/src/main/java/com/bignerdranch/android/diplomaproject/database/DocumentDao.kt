package com.bignerdranch.android.diplomaproject.database

import androidx.room.Dao
import androidx.room.Query
import com.bignerdranch.android.diplomaproject.Document
import kotlinx.coroutines.flow.Flow
import java.util.*

@Dao
interface DocumentDao {
    @Query("SELECT * FROM document")
    fun getDocuments(): Flow<List<Document>>

    @Query("SELECT * FROM document WHERE id=(:id)")
    suspend fun getDocument(id: UUID): Document
}