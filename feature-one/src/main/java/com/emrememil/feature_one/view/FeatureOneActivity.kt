package com.emrememil.feature_one.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.emrememil.core.model.Employee
import com.emrememil.core.usecase.AddEmployee
import com.emrememil.core.utils.InjectUtils
import com.emrememil.feature_one.R
import com.emrememil.feature_one.di.DaggerFeatureOneComponent
import kotlinx.android.synthetic.main.activity_feature_one.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class FeatureOneActivity : AppCompatActivity() {

    @Inject
    lateinit var addEmployee: AddEmployee

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feature_one)

        DaggerFeatureOneComponent
            .builder()
            .coreComponent(InjectUtils.provideAppComponent(applicationContext))
            .build()
            .inject(this)

        btnAddEmployee.setOnClickListener {
            GlobalScope.launch {
                addEmployee(Employee(1, "Emre", "", "Ankara/Turkey"))
            }
            Toast.makeText(this, "Employee added. Name: Emre", Toast.LENGTH_LONG).show()
        }
    }
}