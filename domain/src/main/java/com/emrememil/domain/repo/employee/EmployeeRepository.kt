package com.emrememil.domain.repo.employee

import com.emrememil.domain.database.dao.EmployeeDao
import com.emrememil.domain.model.Employee
import javax.inject.Inject

class EmployeeRepositoryImpl @Inject constructor(
    private val employeeDao: EmployeeDao
) : EmployeeRepository {

    override fun addNewEmployee(employee: Employee) {
        employeeDao.insert(employee)
    }

    override fun getFirstEmployee(): Employee? {
        return employeeDao.getFirstEmployee()
    }

}

interface EmployeeRepository {
    fun addNewEmployee(employee: Employee)
    fun getFirstEmployee(): Employee?
}