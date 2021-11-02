package com.emrememil.feature_one.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.emrememil.domain.extensions.viewModelProvider
import com.emrememil.domain.utils.InjectUtils
import com.emrememil.feature_one.R
import com.emrememil.feature_one.di.DaggerFeatureOneComponent
import com.emrememil.feature_one.viewmodel.FeatureOneViewModel
import kotlinx.android.synthetic.main.activity_feature_one.*
import javax.inject.Inject

class FeatureOneActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var viewModel: FeatureOneViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feature_one)

        DaggerFeatureOneComponent
            .builder()
            .coreComponent(InjectUtils.provideAppComponent(applicationContext))
            .build()
            .inject(this)

        viewModel = viewModelProvider(viewModelFactory)

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
    }
}