package com.syuzanna.reminder

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [UserModel::class], version = 1)
abstract class UserDb : RoomDatabase() {
    abstract fun userDao(): UserDao

    companion object {
        private var INSTANCE : UserDb? = null

        fun getInstance(context: Context) : UserDb {


            //same as in return
//            if (INSTANCE == null) {
//                INSTANCE = Room.databaseBuilder(context, UserDb::class.java, "User_database").build()
//            }


            return INSTANCE ?: Room.databaseBuilder(context.applicationContext, UserDb::class.java, "User_database").build().also {
                INSTANCE = it
            }
        }
    }
}