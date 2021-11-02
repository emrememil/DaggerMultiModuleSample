package com.emrememil.core.di

import android.content.Context
import com.emrememil.core.di.modules.ContextModule
import com.emrememil.core.di.modules.DatabaseModule
import com.emrememil.core.di.modules.ReposModule
import com.emrememil.core.repo.employee.EmployeeRepository
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        ContextModule::class,
        DatabaseModule::class,
        ReposModule::class
    ]
)
interface CoreComponent {
    /**
     * Provide dependency graph Context
     *
     * @return Context
     */
    fun context(): Context

    /**
     * Provide dependency graph EmployeeRepository
     *
     * @return EmployeeRepository
     */
    fun employeeRepo(): EmployeeRepository
}