package com.emrememil.core.database.dao

import androidx.room.Dao
import androidx.room.Query
import com.emrememil.core.model.Employee

@Dao
interface EmployeeDao : BaseDao<Employee> {
    @Query ("Select * from Employee WHERE uid = 1")
    fun getFirstEmployee(): Employee?
}