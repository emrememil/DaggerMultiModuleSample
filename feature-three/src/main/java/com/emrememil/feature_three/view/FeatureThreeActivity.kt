package com.emrememil.feature_three.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.emrememil.core.utils.InjectUtils
import com.emrememil.feature_three.R
import com.emrememil.feature_three.di.DaggerFeatureThreeComponent

class FeatureThreeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feature_three)

        DaggerFeatureThreeComponent
            .builder()
            .coreComponent(InjectUtils.provideAppComponent(applicationContext))
            .build()
            .inject(this)
    }
}