package com.hajar.managementusers.data
import androidx.room.Database
import androidx.room.RoomDatabase
import com.hajar.managementusers.model.User


@Database(entities = [User::class, Role::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun roleDao(): RoleDao
}
