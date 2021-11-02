package com.emrememil.feature_one.di

import com.emrememil.domain.di.CoreComponent
import com.emrememil.domain.di.scopes.FeatureScope
import com.emrememil.feature_one.view.FeatureOneActivity
import dagger.Component

@FeatureScope
@Component(
    dependencies = [CoreComponent::class],
    modules = [FeatureOneModule::class, ViewModelModule::class]
)
interface FeatureOneComponent {
    fun inject(activity: FeatureOneActivity)
}