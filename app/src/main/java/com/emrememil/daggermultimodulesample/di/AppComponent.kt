package com.emrememil.daggermultimodulesample.di

import com.emrememil.core.di.CoreComponent
import com.emrememil.core.di.scopes.AppScope
import com.emrememil.daggermultimodulesample.SampleApp
import dagger.Component

@AppScope
@Component(
    dependencies = [CoreComponent::class],
    modules = [AppModule::class]
)
interface AppComponent {
    /**
     * Inject dependencies on application.
     *
     * @param application The sample application.
     */
    fun inject(application: SampleApp)
}