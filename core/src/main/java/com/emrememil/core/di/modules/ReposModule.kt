package com.emrememil.core.di.modules

import com.emrememil.core.repo.employee.EmployeeRepository
import com.emrememil.core.repo.employee.EmployeeRepositoryImpl
import dagger.Module
import dagger.Provides

@Module
class ReposModule {

    /**
     * Create a provider method binding for [EmployeeRepositoryImpl].
     *
     * @return Instance of employee repository.
     * @see Provides
     */
    @Provides
    fun provideEmployeeRepository(
        employeeRepositoryImpl: EmployeeRepositoryImpl
    ): EmployeeRepository {
        return employeeRepositoryImpl
    }

}