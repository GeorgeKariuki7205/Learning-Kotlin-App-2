package com.example.learningkotlinapp2.addNewProfile


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.NavHostFragment
import com.example.learningkotlinapp2.MainActivity

import com.example.learningkotlinapp2.R
import com.example.learningkotlinapp2.database.PersonalData
import com.example.learningkotlinapp2.database.PersonalDataDataBase
import com.example.learningkotlinapp2.databinding.FragmentAddNewProfileBinding
import com.example.learningkotlinapp2.personalData.PersonalDataDirections
import com.example.learningkotlinapp2.personalData.PersonalDataViewModel
import com.example.learningkotlinapp2.personalData.PersonalDataViewModelFactory
import kotlinx.android.synthetic.main.fragment_add_new_profile.*


class AddNewProfile : Fragment() {
    private  lateinit var binding: FragmentAddNewProfileBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        (activity as MainActivity).supportActionBar?.title = "Add New Profile."
//        return inflater.inflate(R.layout.fragment_add_new_profile, container, false)
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_add_new_profile,
            container,
            false
        )

        val application = requireNotNull(this.activity).application
        val dataSource = PersonalDataDataBase.getInstance(application).personalDataDao
        val viewModelFactory = AddNewProfileViewModelFactory(dataSource,application)
        val addNewProfileViewModel = ViewModelProviders.of(this, viewModelFactory).get(AddNewProfileViewModel::class.java)
        binding.addNewProfileViewModel= addNewProfileViewModel
        binding.setLifecycleOwner(this)

//        addNewProfileViewModel.checker.observe()
        addNewProfileViewModel.checker.observe(this, Observer {
            newCheckerValue->
            if(newCheckerValue.toInt() == 1){

//

                val action = AddNewProfileDirections.actionAddNewProfileToPersonalData()
                NavHostFragment.findNavController(this).navigate(action)
            }
        })

        binding.add.setOnClickListener {
//            Validating the input that the user has added.

            if(binding.firstName.text?.length == 0){
                    binding.firstNameLayout.error = "The Name Must Be Of more than one character."
            }
            else if(binding.secondName.text?.length == 0){
                binding.secondNameLayout.error = "The Name Must Be Of more than one character."
            }
            else{
//                val profileDetails = listOf(0L, firstName.text.toString(), secondName.text.toString(), age.text)
                  val profileDetails = listOf<PersonalData>(PersonalData(0L, firstName.text.toString(), secondName.text.toString(),21))
                addNewProfileViewModel.addNewProfile(profileDetails)
            }
        }

        binding.clear.setOnClickListener {
            binding.age.error = "This is the error Message."
            Log.i("Get Name",binding.firstName.text.toString())
        }

//        Trial Value.

        var name = "George Kariuki Ngugi."

        return binding.root
    }
}
