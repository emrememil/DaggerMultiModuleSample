package com.emrememil.feature_three.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.emrememil.core.model.Employee
import com.emrememil.core.usecase.AddEmployee
import com.emrememil.core.usecase.GetFirstEmployee
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class FeatureThreeViewModel @Inject constructor(
    val addEmployee: AddEmployee,
    val getFirstEmployee: GetFirstEmployee
) : ViewModel() {

    val addedEmployee = MutableLiveData<Employee?>()
    val firstEmployee = MutableLiveData<Employee?>()

    fun addNewEmployee() {
        GlobalScope.launch {
            val employee = Employee(1, "Emre", "", "Ankara/Turkey")

            val result = addEmployee(employee)

            if (result) {
                addedEmployee.value = employee
            } else {
                addedEmployee.value = null
            }
        }
    }

    fun getFirstEmployeeFromDB() {
        GlobalScope.launch {
            val result = getFirstEmployee(Any())
            firstEmployee.value = result
        }
    }
}