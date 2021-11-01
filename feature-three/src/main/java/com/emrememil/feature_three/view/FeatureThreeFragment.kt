package com.emrememil.feature_three.view

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.emrememil.core.database.dao.EmployeeDao
import com.emrememil.core.utils.InjectUtils
import com.emrememil.feature_three.R
import com.emrememil.feature_three.di.DaggerFeatureThreeComponent
import javax.inject.Inject


class FeatureThreeFragment : Fragment() {

    @Inject
    lateinit var employeeDao: EmployeeDao

    override fun onAttach(context: Context) {
        super.onAttach(context)
        DaggerFeatureThreeComponent
            .builder()
            .coreComponent(InjectUtils.provideAppComponent(requireContext().applicationContext))
            .build()
            .injectFeatureThreeFragment(this)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Toast.makeText(requireContext(), employeeDao.getFirstEmployee()?.name ?: "Employee Not Found" , Toast.LENGTH_LONG)
            .show()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_feature_three, container, false)
    }


    companion object {
        const val TAG = "FeatureThreeFragment"

        fun newInstance(): FeatureThreeFragment {
            return FeatureThreeFragment()
        }
    }

}