package com.app.database.users

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UsersDao {
    @Insert(onConflict = OnConflictStrategy.ABORT)
    fun insertUserEntity(model: UserEntity)

    @Query("SELECT * FROM UserEntity where email=:email")
    fun getUserEntity(email: String): UserEntity?

    @Query("DELETE FROM UserEntity where email=:email")
    fun deleteUserEntity(email: String)
}