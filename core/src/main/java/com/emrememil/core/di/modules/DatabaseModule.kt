package com.emrememil.core.di.modules

import android.content.Context
import androidx.room.Room
import com.emrememil.core.database.AppDatabase
import com.emrememil.core.database.dao.EmployeeDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {
    @Singleton
    @Provides
    fun provideDatabase(context: Context) =
        Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "SampleDb"
        ).allowMainThreadQueries()
            .build()

    @Singleton
    @Provides
    fun providesEmployeeDao(parameter: AppDatabase): EmployeeDao {
        return parameter.getEmployeeDao()
    }

}