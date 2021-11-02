package com.emrememil.domain.utils

import android.content.Context
import com.emrememil.domain.di.MainComponent
import com.emrememil.domain.di.MainComponentProvider

object InjectUtils {
    fun provideAppComponent(applicationContext: Context): MainComponent {
        return if (applicationContext is MainComponentProvider) {
            (applicationContext as MainComponentProvider).provideMainComponent()
        } else {
            throw IllegalStateException("Provide the application context which implement AppComponentProvider")
        }
    }
}