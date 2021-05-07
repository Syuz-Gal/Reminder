package com.syuzanna.reminder

import androidx.room.*

@Dao
interface UserDao {

    @Query("SELECT * FROM users")
    fun getAllUsers(): List<UserModel>

//    @Query("SELECT * FROM users LIMIT 1")
//    fun getFirstElement() : UserModel

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addUser(userModel: UserModel)

    @Insert
    fun addUsers(users: List<UserModel>)

    @Delete
    fun deleteUser(user: UserModel)

    @Update
    fun update(user:UserModel)
}