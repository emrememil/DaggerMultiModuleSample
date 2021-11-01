package com.emrememil.feature_two.di

import com.emrememil.core.di.CoreComponent
import com.emrememil.core.di.scopes.FeatureScope
import com.emrememil.feature_two.view.FeatureTwoActivity
import dagger.Component

@FeatureScope
@Component(
    dependencies = [CoreComponent::class],
    modules = [FeatureTwoModule::class]
)
interface FeatureTwoComponent {
    fun inject(activity: FeatureTwoActivity)
}