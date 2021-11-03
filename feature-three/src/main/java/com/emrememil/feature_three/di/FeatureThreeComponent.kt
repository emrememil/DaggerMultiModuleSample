package com.emrememil.feature_three.di

import com.emrememil.domain.di.MainComponent
import com.emrememil.domain.di.scopes.FeatureScope
import com.emrememil.feature_three.view.FeatureThreeActivity
import com.emrememil.feature_three.view.FeatureThreeFragment
import dagger.Component

@FeatureScope
@Component(
    dependencies = [MainComponent::class],
    modules = [
        FeatureThreeModule::class,
//        ViewModelModule::class
    ]
)
interface FeatureThreeComponent {
    fun inject(activity: FeatureThreeActivity)
    fun injectFeatureThreeFragment(fragment: FeatureThreeFragment)
}