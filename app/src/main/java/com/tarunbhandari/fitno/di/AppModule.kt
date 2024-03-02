package com.tarunbhandari.fitno.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.tarunbhandari.fitno.data.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideSharedPreferences(context: Context): SharedPreferences {
        return context.getSharedPreferences("Fitno_Shared_Preferences", Context.MODE_PRIVATE)
    }

    @Provides
    @Singleton
    fun provideApplicationContext(application: Application): Context {
        return application.applicationContext
    }

    @Provides
    fun provideCoroutineScope(): CoroutineScope = CoroutineScope(SupervisorJob())

    @Provides
    fun provideAppDatabase(context: Context, scope: CoroutineScope): AppDatabase {
        return AppDatabase.getDatabase(context, scope)
    }

}


