package com.emrememil.feature_one.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.emrememil.core.model.Employee
import com.emrememil.core.usecase.AddEmployee
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class FeatureOneViewModel @Inject constructor(
    val addEmployee: AddEmployee
) : ViewModel() {
    val addedEmployee = MutableLiveData<Employee?>()

    fun addNewEmployee() {
        GlobalScope.launch {
            withContext(Dispatchers.Main) {
                val employee = Employee(1, "Emre", "", "Ankara/Turkey")

                val result = addEmployee(employee)

                if (result) {
                    addedEmployee.value = employee
                } else {
                    addedEmployee.value = null
                }
            }
        }
    }
}