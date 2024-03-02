package com.tarunbhandari.fitno.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.tarunbhandari.fitno.data.local.challenge.Challenge
import com.tarunbhandari.fitno.data.local.challenge.ChallengeDao
import com.tarunbhandari.fitno.data.local.challenge.initialChallenges
import com.tarunbhandari.fitno.data.local.user.UserDao
import com.tarunbhandari.fitno.data.local.user.Users
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Database(
    entities = [Users::class, Challenge::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase: RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun challengeDao(): ChallengeDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context, scope: CoroutineScope): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "fitno_database"
                )
                    .addCallback(DatabaseCallback(scope))
                    .build()

                INSTANCE = instance
                instance
            }
        }
    }

    private class DatabaseCallback(private val scope: CoroutineScope): RoomDatabase.Callback() {
        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            INSTANCE?.let { database ->
                scope.launch(Dispatchers.IO) {
                    populateChallenges(database.challengeDao())
                }
            }
        }


        // Pre-populating the challenges table with the Challenges written in the ChallengesData file
        suspend fun populateChallenges(challengeDao: ChallengeDao) {
            initialChallenges.forEach{ initialChallenges ->
                challengeDao.addChallenges(initialChallenges)
            }
        }
    }
}


