package com.emrememil.daggermultimodulesample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.emrememil.feature_one.view.FeatureOneActivity
import com.emrememil.feature_two.view.FeatureTwoActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnFeatureOne.setOnClickListener {
            startActivity(Intent(this, FeatureOneActivity::class.java))
        }

        btnFeatureTwo.setOnClickListener {
            startActivity(Intent(this, FeatureTwoActivity::class.java))
        }
    }
}