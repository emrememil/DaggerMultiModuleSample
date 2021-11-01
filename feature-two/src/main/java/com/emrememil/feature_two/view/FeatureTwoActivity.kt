package com.emrememil.feature_two.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.emrememil.core.database.dao.EmployeeDao
import com.emrememil.core.utils.InjectUtils
import com.emrememil.feature_three.view.FeatureThreeActivity
import com.emrememil.feature_two.R
import com.emrememil.feature_two.di.DaggerFeatureTwoComponent
import kotlinx.android.synthetic.main.activity_feature_two.*
import javax.inject.Inject

class FeatureTwoActivity : AppCompatActivity() {

    @Inject
    lateinit var employeeDao: EmployeeDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feature_two)

        DaggerFeatureTwoComponent
            .builder()
            .coreComponent(InjectUtils.provideAppComponent(applicationContext))
            .build()
            .inject(this)

        btnFeatureThree.setOnClickListener {
            startActivity(Intent(this, FeatureThreeActivity::class.java))
        }

        btnShowEmployee.setOnClickListener {
            val name = employeeDao.getFirstEmployee()?.name
            Toast.makeText(this, name ?: "Employee Not Found", Toast.LENGTH_LONG).show()
        }
    }
}