package com.example.testapracticodipas.di

import android.content.Context
import androidx.room.Room
import com.example.testapracticodipas.data.Apis
import com.example.testapracticodipas.room.TestDatabase
import com.example.testapracticodipas.room.TestDatabaseDao
import com.example.testapracticodipas.util.Constants.Companion.BASE_URL2
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun providesRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL2)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun providesApisGames( retrofit: Retrofit): Apis{
        return retrofit.create( Apis::class.java)
    }

    @Singleton
    @Provides
    fun providesTestDao(testDatabase: TestDatabase) : TestDatabaseDao{
        return testDatabase.testDao()
    }

    @Singleton
    @Provides
    fun providesTestDatabase(@ApplicationContext context: Context): TestDatabase{
        return Room.databaseBuilder(
            context,
            TestDatabase::class.java,
            "test_db"
        ).fallbackToDestructiveMigration()
            .build()
    }
}