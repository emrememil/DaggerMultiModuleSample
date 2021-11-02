package com.emrememil.domain.utils

import android.content.Context
import com.emrememil.domain.di.CoreComponent
import com.emrememil.domain.di.CoreComponentProvider

object InjectUtils {
    fun provideAppComponent(applicationContext: Context): CoreComponent {
        return if (applicationContext is CoreComponentProvider) {
            (applicationContext as CoreComponentProvider).provideCoreComponent()
        } else {
            throw IllegalStateException("Provide the application context which implement AppComponentProvider")
        }
    }
}