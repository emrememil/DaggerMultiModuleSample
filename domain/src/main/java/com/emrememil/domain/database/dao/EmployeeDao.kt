package com.emrememil.domain.database.dao

import androidx.room.Dao
import androidx.room.Query
import com.emrememil.domain.model.Employee

@Dao
interface EmployeeDao : BaseDao<Employee> {
    @Query ("Select * from Employee WHERE uid = 1")
    fun getFirstEmployee(): Employee?
}