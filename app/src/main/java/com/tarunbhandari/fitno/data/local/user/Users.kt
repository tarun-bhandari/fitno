package com.tarunbhandari.fitno.data.local.user

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.tarunbhandari.fitno.util.Gender

@Entity(
    tableName = "User"
)
data class Users(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val name: String,
    val age: Int,
    val gender: String,
    val weight: Double? = 0.0,
    val points: Int
)
