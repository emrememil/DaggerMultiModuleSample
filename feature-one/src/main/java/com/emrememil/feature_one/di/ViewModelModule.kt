package com.emrememil.feature_one.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.emrememil.core.di.scopes.ViewModelKey
import com.emrememil.core.utils.ViewModelFactory
import com.emrememil.feature_one.viewmodel.FeatureOneViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(FeatureOneViewModel::class)
    abstract fun bindFeatureOneViewModel(featureOneViewModel: FeatureOneViewModel): ViewModel
}