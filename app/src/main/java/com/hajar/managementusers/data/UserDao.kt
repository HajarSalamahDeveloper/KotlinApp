package com.hajar.managementusers.data
import androidx.room.*
import com.hajar.managementusers.model.User

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(user: User)

    @Query("SELECT * FROM users WHERE email = :email")
    suspend fun findByEmail(email: String): User?

    @Query("SELECT * FROM users WHERE phoneNumber = :phoneNumber")
    suspend fun findByPhoneNumber(phoneNumber: String): User?
}
