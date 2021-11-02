package com.emrememil.domain.di

import android.content.Context
import com.emrememil.domain.di.modules.ContextModule
import com.emrememil.domain.di.modules.DatabaseModule
import com.emrememil.domain.di.modules.ReposModule
import com.emrememil.domain.repo.employee.EmployeeRepository
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