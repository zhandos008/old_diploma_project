package com.bignerdranch.android.diplomaproject

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class Document (
    @PrimaryKey val id: UUID,
    val name: String)