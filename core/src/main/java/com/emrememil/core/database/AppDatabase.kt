package com.emrememil.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.emrememil.core.database.dao.EmployeeDao
import com.emrememil.core.model.Employee

@Database(
    entities = [Employee::class],
    version = 1, exportSchema = true
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getEmployeeDao(): EmployeeDao
}