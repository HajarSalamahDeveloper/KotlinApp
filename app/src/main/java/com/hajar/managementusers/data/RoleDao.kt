package com.hajar.managementusers.data

import androidx.room.*

@Dao
interface RoleDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(role: Role)

    @Query("SELECT * FROM roles WHERE name = :name")
    suspend fun findByName(name: String): Role?
}
