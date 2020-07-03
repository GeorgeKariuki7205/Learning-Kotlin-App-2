package com.example.learningkotlinapp2.personalData


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.NavHostFragment
import com.example.learningkotlinapp2.MainActivity

import com.example.learningkotlinapp2.R
import com.example.learningkotlinapp2.database.PersonalDataDataBase
import com.example.learningkotlinapp2.databinding.FragmentPersonalDataBinding


class PersonalData : Fragment() {
 private  lateinit var binding: FragmentPersonalDataBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_personal_data,
            container,
            false
        )

        (activity as MainActivity).supportActionBar?.title = "Personal Data."
        binding.addNew.setOnClickListener {
            val action = PersonalDataDirections.actionPersonalDataToAddNewProfile2()
            NavHostFragment.findNavController(this).navigate(action)
        }

//        Initialising the creation of the viewModel by using the viewModel Factory.
        val application = requireNotNull(this.activity).application
        val dataSource = PersonalDataDataBase.getInstance(application).personalDataDao
        val viewModelFactory = PersonalDataViewModelFactory(dataSource,application)
        val personalDataViewModel = ViewModelProviders.of(this, viewModelFactory).get(PersonalDataViewModel::class.java)
        binding.personalDataViewModel = personalDataViewModel
        binding.setLifecycleOwner(this)

        return binding.root
    }
}
