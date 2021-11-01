package com.emrememil.feature_one.di

import com.emrememil.core.di.CoreComponent
import com.emrememil.core.di.scopes.FeatureScope
import com.emrememil.feature_one.view.FeatureOneActivity
import dagger.Component

@FeatureScope
@Component(
    dependencies = [CoreComponent::class],
    modules = [FeatureOneModule::class]
)
interface FeatureOneComponent {
    fun inject(activity: FeatureOneActivity)
}