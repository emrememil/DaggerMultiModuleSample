package com.emrememil.daggermultimodulesample

import android.app.Application
import android.content.Context
import com.emrememil.core.di.CoreComponent
import com.emrememil.core.di.CoreComponentProvider
import com.emrememil.core.di.DaggerCoreComponent
import com.emrememil.core.di.modules.ContextModule
import com.emrememil.daggermultimodulesample.di.DaggerAppComponent

class SampleApp : Application(), CoreComponentProvider {

    lateinit var coreComponent: CoreComponent

    override fun onCreate() {
        super.onCreate()

        initCoreDependencyInjection()
        initAppDependencyInjection()
    }

    /**
     * Initialize app dependency injection component.
     */
    private fun initAppDependencyInjection() {
        DaggerAppComponent
            .builder()
            .coreComponent(coreComponent)
            .build()
            .inject(this)
    }

    /**
     * Initialize core dependency injection component.
     */
    private fun initCoreDependencyInjection() {
        coreComponent = DaggerCoreComponent
            .builder()
            .contextModule(ContextModule(this))
            .build()
    }

    override fun provideCoreComponent(): CoreComponent {
        return coreComponent
    }

}