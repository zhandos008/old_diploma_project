package com.bignerdranch.android.diplomaproject

import android.content.Context
import androidx.room.Room
import com.bignerdranch.android.diplomaproject.database.DocumentDataBase
import kotlinx.coroutines.flow.Flow
import java.util.*

private const val DATABASE_NAME = "document-database"

class DocumentRepository private constructor(context: Context) {

    private val database: DocumentDataBase = Room
        .databaseBuilder(
            context.applicationContext,
            DocumentDataBase::class.java,
            DATABASE_NAME
        )
        .build()

    fun getDocuments(): Flow<List<Document>> = database.documentDao().getDocuments()

    suspend fun getDocument(id: UUID): Document = database.documentDao().getDocument(id)


    companion object {
        private var INSTANCE: DocumentRepository? = null

        fun initialize(context: Context) {
            if(INSTANCE == null) {
                INSTANCE = DocumentRepository(context)
            }
        }

        fun get(): DocumentRepository {
            return INSTANCE ?:
            throw IllegalStateException("CrimeRepository must be initialized")
        }
    }
}