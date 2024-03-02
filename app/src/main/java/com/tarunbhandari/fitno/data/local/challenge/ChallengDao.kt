package com.tarunbhandari.fitno.data.local.challenge

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface ChallengeDao {

    @Upsert
    suspend fun addChallenges(challenge: Challenge)

    @Query("SELECT * FROM Challenges")
    suspend fun getAllChallenges(): List<Challenge>

    @Query("SELECT * FROM challenges WHERE cId = :id")
    suspend fun getChallengesByID(id: Long): Challenge?

    @Query("SELECT * FROM challenges WHERE level = :level")
    fun sortChallengesByLevel(level: String): Flow<List<Challenge>>

    @Query("SELECT * FROM challenges WHERE isChallengeCompleted = :complete")
    fun sortChallengesByStatus(complete: Boolean): Flow<List<Challenge>>

    @Query("UPDATE Challenges SET isChallengeCompleted = :complete WHERE cId = :id")
    suspend fun updateChallengeStatus(complete: Boolean, id: Long)
}