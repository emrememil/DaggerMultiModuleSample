package com.emrememil.core.extensions

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

fun <T : Any, L : LiveData<T>> LifecycleOwner.observe(liveData: L, body: (T?) -> Unit) {
    liveData.observe(this, Observer(body))
}

inline fun <reified VM : ViewModel> FragmentActivity.viewModelProvider(provider: ViewModelProvider.Factory) =
    ViewModelProvider(this, provider).get(VM::class.java)

inline fun <reified VM : ViewModel> Fragment.viewModelProvider(provider: ViewModelProvider.Factory) =
    ViewModelProvider(this, provider).get(VM::class.java)

fun Fragment.getGrandParentFragment(): Fragment? {
    return requireParentFragment().parentFragment
}