package com.emrememil.feature_three.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.emrememil.core_android.ViewModelFactory
import com.emrememil.domain.di.scopes.ViewModelKey
import com.emrememil.feature_three.viewmodel.FeatureThreeViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(FeatureThreeViewModel::class)
    abstract fun bindFeatureThreeViewModel(featureThreeViewModel: FeatureThreeViewModel): ViewModel
}