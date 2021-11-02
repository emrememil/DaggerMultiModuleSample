package com.emrememil.daggermultimodulesample

import android.app.Application
import com.emrememil.domain.di.MainComponent
import com.emrememil.domain.di.MainComponentProvider
import com.emrememil.domain.di.DaggerMainComponent
import com.emrememil.domain.di.modules.ContextModule
import com.emrememil.daggermultimodulesample.di.DaggerAppComponent

class SampleApp : Application(), MainComponentProvider {

    lateinit var mainComponent: MainComponent

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
            .mainComponent(mainComponent)
            .build()
            .inject(this)
    }

    /**
     * Initialize core dependency injection component.
     */
    private fun initCoreDependencyInjection() {
        mainComponent = DaggerMainComponent
            .builder()
            .contextModule(ContextModule(this))
            .build()
    }

    override fun provideMainComponent(): MainComponent {
        return mainComponent
    }

}