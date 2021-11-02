package com.emrememil.core.usecase

import android.util.Log
import com.emrememil.core.model.Employee
import com.emrememil.core.repo.employee.EmployeeRepository
import com.emrememil.core.utils.UseCase
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