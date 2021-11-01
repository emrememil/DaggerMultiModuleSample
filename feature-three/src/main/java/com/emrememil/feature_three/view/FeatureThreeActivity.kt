package com.emrememil.feature_three.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.emrememil.core.utils.InjectUtils
import com.emrememil.feature_three.R
import com.emrememil.feature_three.di.DaggerFeatureThreeComponent
import kotlinx.android.synthetic.main.activity_feature_three.*

class FeatureThreeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feature_three)

        DaggerFeatureThreeComponent
            .builder()
            .coreComponent(InjectUtils.provideAppComponent(applicationContext))
            .build()
            .inject(this)

        btnFeatureThreeFragment.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(
                    R.id.container,
                    FeatureThreeFragment.newInstance(),
                    FeatureThreeFragment.TAG
                ).addToBackStack(FeatureThreeFragment.TAG).commit()

            textViewThree.visibility = View.GONE
            btnFeatureThreeFragment.visibility = View.GONE
        }
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount > 0) {
            supportFragmentManager.popBackStackImmediate()
            textViewThree.visibility = View.VISIBLE
            btnFeatureThreeFragment.visibility = View.VISIBLE
        } else {
            super.onBackPressed()
        }
    }
}