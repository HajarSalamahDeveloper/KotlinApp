package com.hajar.managementusers.data

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "roles")
data class Role(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val name: String
)

