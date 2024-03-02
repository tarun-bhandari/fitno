package com.tarunbhandari.fitno.data.local.user

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {

    @Upsert
    suspend fun insertOrUpdateUser(users: Users)

    @Delete
    suspend fun deleteUser(users: Users)

    @Query("SELECT * FROM User")
    fun getAllUser(): Flow<List<Users>>

    @Query("SELECT points FROM User WHERE id=:id")
    suspend fun getUserPoints(id: Int): Int

    @Query("UPDATE User SET points = :newPoints WHERE id = :id")
    suspend fun updateUserPoints(id: Long, newPoints: Int)

}