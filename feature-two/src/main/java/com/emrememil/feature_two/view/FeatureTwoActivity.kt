package com.emrememil.feature_two.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.emrememil.domain.usecase.GetFirstEmployee
import com.emrememil.domain.utils.InjectUtils
import com.emrememil.feature_two.R
import com.emrememil.feature_two.di.DaggerFeatureTwoComponent
import com.gaelmarhic.quadrant.QuadrantConstants
import kotlinx.android.synthetic.main.activity_feature_two.*
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

class FeatureTwoActivity : AppCompatActivity() {

    @Inject
    lateinit var getFirstEmployee: GetFirstEmployee

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feature_two)

        DaggerFeatureTwoComponent
            .builder()
            .mainComponent(InjectUtils.provideAppComponent(applicationContext))
            .build()
            .inject(this)

        btnFeatureThree.setOnClickListener {
            val intent = Intent()
            intent.setClassName(this, QuadrantConstants.FEATURE_THREE_ACTIVITY)
            startActivity(intent)
        }

        btnShowEmployee.setOnClickListener {
            var name: String?
            runBlocking {
                name = getFirstEmployee(Any())?.name
            }
            Toast.makeText(this, name ?: "Employee Not Found", Toast.LENGTH_LONG).show()
        }
    }
}