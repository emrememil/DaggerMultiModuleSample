package com.emrememil.domain.usecase

import android.util.Log
import com.emrememil.core.UseCase
import com.emrememil.domain.model.Employee
import com.emrememil.domain.repo.employee.EmployeeRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class AddEmployee @Inject constructor(
    private val employeeRepository: EmployeeRepository
) : UseCase<Employee, Boolean>() {
    override suspend fun execute(parameters: Employee): Boolean =
        withContext(Dispatchers.IO) {
            try {
                employeeRepository.addNewEmployee(parameters)
                return@withContext true
            } catch (e: Exception) {
                Log.e(TAG, e.message.toString())
                return@withContext false
            }
        }

    companion object {
        const val TAG = "AddEmployeeUseCase"
    }
}