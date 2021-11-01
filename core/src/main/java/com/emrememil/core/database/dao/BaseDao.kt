package com.emrememil.core.database.dao

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Update

interface BaseDao<T> {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg entity: T)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(entity: List<T>)

    @Update
    fun update(entity: T)

    @Delete
    fun delete(entity: T)
}