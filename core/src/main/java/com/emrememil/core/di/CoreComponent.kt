package com.emrememil.core.di

import android.content.Context
import com.emrememil.core.database.dao.EmployeeDao
import com.emrememil.core.di.modules.ContextModule
import com.emrememil.core.di.modules.DatabaseModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        ContextModule::class,
        DatabaseModule::class
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
     * Provide dependency graph EmployeeDao
     *
     * @return EmployeeDao
     */
    fun employeeDao(): EmployeeDao
}