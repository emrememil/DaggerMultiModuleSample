package com.emrememil.core.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Employee")
data class Employee(
    @PrimaryKey
    @ColumnInfo(name = "uid")
    val uid: Long,

    @ColumnInfo(name = "name")
    val name: String,

    @ColumnInfo(name = "photo")
    val photo: String,

    @ColumnInfo(name = "address")
    val adress: String
)