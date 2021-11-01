package com.emrememil.feature_three.di

import com.emrememil.core.di.CoreComponent
import com.emrememil.core.di.scopes.FeatureScope
import com.emrememil.feature_three.view.FeatureThreeActivity
import dagger.Component

@FeatureScope
@Component(
    dependencies = [CoreComponent::class],
    modules = [FeatureThreeModule::class]
)
interface FeatureThreeComponent {
    fun inject(activity: FeatureThreeActivity)
}