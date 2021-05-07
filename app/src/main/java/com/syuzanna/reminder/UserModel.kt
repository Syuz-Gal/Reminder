package com.syuzanna.reminder

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "users")
data class UserModel(
        @PrimaryKey(autoGenerate = true)
        val id: Int,
        val note: String,
        val date: String,
        val time: String
)