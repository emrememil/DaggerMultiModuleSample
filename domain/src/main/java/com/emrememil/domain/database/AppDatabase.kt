package com.emrememil.domain.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.emrememil.domain.database.dao.EmployeeDao
import com.emrememil.domain.model.Employee

@Database(
    entities = [Employee::class],
    version = 1, exportSchema = true
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getEmployeeDao(): EmployeeDao
}