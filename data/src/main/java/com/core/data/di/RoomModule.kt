package com.core.data.di

import android.content.Context
import androidx.room.Room
import com.app.database.AppDatabase
import com.app.database.users.UsersDao
import com.core.data.controlers.UsersController
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RoomModule {
    @Provides
    @Singleton
    fun provideAppDatabase(
        @ApplicationContext appContext: Context,
        name: String
    ): AppDatabase {
        return Room.databaseBuilder(
            appContext,
            AppDatabase::class.java,
            name
        ).build()
    }

    @Provides
    @Singleton
    fun provideUsersDao(
        appDatabase: AppDatabase
    ) = appDatabase.usersDao()

    @Provides
    @Singleton
    fun provideUsersController(
        usersDao: UsersDao,
    ) = UsersController(usersDao)

}
