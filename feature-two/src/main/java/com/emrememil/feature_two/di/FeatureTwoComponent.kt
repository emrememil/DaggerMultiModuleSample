package com.emrememil.feature_two.di

import com.emrememil.domain.di.MainComponent
import com.emrememil.domain.di.scopes.FeatureScope
import com.emrememil.feature_two.view.FeatureTwoActivity
import dagger.Component

@FeatureScope
@Component(
    dependencies = [MainComponent::class],
    modules = [FeatureTwoModule::class]
)
interface FeatureTwoComponent {
    fun inject(activity: FeatureTwoActivity)
}