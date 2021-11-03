package com.emrememil.feature_three.di

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.emrememil.core.extensions.viewModel
import com.emrememil.domain.di.scopes.FeatureScope
import com.emrememil.domain.usecase.AddEmployee
import com.emrememil.domain.usecase.GetFirstEmployee
import com.emrememil.feature_three.viewmodel.FeatureThreeViewModel
import dagger.Module
import dagger.Provides

@Module
class FeatureThreeModule(val fragmentOrActivity: Any) {

    @FeatureScope
    @Provides
    fun provideFeatureThreeViewModel(
        addEmployee: AddEmployee,
        getFirstEmployee: GetFirstEmployee
    ) : FeatureThreeViewModel {
        return if (fragmentOrActivity is FragmentActivity) {
            fragmentOrActivity.viewModel {
                FeatureThreeViewModel(
                    addEmployee = addEmployee,
                    getFirstEmployee = getFirstEmployee
                )
            }
        } else {
            (fragmentOrActivity as Fragment).viewModel {
                FeatureThreeViewModel(
                    addEmployee = addEmployee,
                    getFirstEmployee = getFirstEmployee
                )
            }
        }
    }
}