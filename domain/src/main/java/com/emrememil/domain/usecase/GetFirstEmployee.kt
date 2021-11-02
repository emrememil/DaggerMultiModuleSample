package com.emrememil.domain.usecase

import android.util.Log
import com.emrememil.core.UseCase
import com.emrememil.domain.model.Employee
import com.emrememil.domain.repo.employee.EmployeeRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetFirstEmployee @Inject constructor(
    private val employeeRepository: EmployeeRepository
) : UseCase<Any, Employee?>() {
    override suspend fun execute(parameters: Any): Employee? = withContext(Dispatchers.IO) {
        try {
            return@withContext employeeRepository.getFirstEmployee()
        } catch (e: Exception) {
            Log.e(TAG, e.message.toString())
            return@withContext null
        }
    }

    companion object {
        const val TAG = "GetFirstEmployeeUseCase"
    }
}