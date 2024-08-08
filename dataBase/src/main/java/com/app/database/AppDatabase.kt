package com.app.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.app.database.users.UserEntity
import com.app.database.users.UsersDao

@Database(
    entities = [UserEntity::class],
    version = 2
)

@TypeConverters(value = [])
abstract class AppDatabase : RoomDatabase() {
    abstract fun usersDao(): UsersDao
}