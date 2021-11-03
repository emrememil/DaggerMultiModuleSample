package com.emrememil.feature_three.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.emrememil.core.extensions.viewModelProvider
import com.emrememil.domain.utils.InjectUtils
import com.emrememil.feature_three.R
import com.emrememil.feature_three.di.DaggerFeatureThreeComponent
import com.emrememil.feature_three.di.FeatureThreeModule
import com.emrememil.feature_three.viewmodel.FeatureThreeViewModel
import kotlinx.android.synthetic.main.activity_feature_three.*
import javax.inject.Inject

class FeatureThreeActivity : AppCompatActivity() {

//    @Inject
//    lateinit var viewModelFactory: ViewModelProvider.Factory

    @Inject
    lateinit var viewModel: FeatureThreeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feature_three)

        DaggerFeatureThreeComponent
            .builder()
            .mainComponent(InjectUtils.provideAppComponent(applicationContext))
            .featureThreeModule(FeatureThreeModule(this))
            .build()
            .inject(this)

//        viewModel = viewModelProvider(viewModelFactory)

        viewModel.addedEmployee.observe(this, {
            if (it != null) {
                Toast.makeText(
                    this,
                    "Employee Added. Name: ${it.name}",
                    Toast.LENGTH_LONG
                ).show()
            } else {
                Toast.makeText(
                    this,
                    "Could not add employee",
                    Toast.LENGTH_LONG
                ).show()

            }
        })

        btnAddEmployee.setOnClickListener {
            viewModel.addNewEmployee()
        }

        btnFeatureThreeFragment.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(
                    R.id.container,
                    FeatureThreeFragment.newInstance(),
                    FeatureThreeFragment.TAG
                ).addToBackStack(FeatureThreeFragment.TAG).commit()

            textViewThree.visibility = View.GONE
            btnFeatureThreeFragment.visibility = View.GONE
            btnAddEmployee.visibility = View.GONE
        }
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount > 0) {
            supportFragmentManager.popBackStackImmediate()
            textViewThree.visibility = View.VISIBLE
            btnFeatureThreeFragment.visibility = View.VISIBLE
            btnAddEmployee.visibility = View.VISIBLE
        } else {
            super.onBackPressed()
        }
    }
}