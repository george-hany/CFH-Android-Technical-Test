package com.app.database.users

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserEntity(
    var firstName: String = "",
    var lastName: String = "",
    var age: Int = 0,
    @PrimaryKey(autoGenerate = false) var email: String = "",
    var password: String = "",
)