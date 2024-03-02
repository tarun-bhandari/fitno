package com.tarunbhandari.fitno.data.local.challenge

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Challenges")
data class Challenge(
    @PrimaryKey(autoGenerate = true) val cId: Long = 0,
    val name: String,
    val desc: String,
    val level: String,
    val isChallengeCompleted: Boolean = false
)
