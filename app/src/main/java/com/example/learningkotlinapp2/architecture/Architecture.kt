package com.example.learningkotlinapp2.architecture


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavHostController
import androidx.navigation.fragment.NavHostFragment

import com.example.learningkotlinapp2.R
import com.example.learningkotlinapp2.databinding.FragmentArchitectureBinding

class Architecture : Fragment() {
    private lateinit var binding: FragmentArchitectureBinding
    private lateinit var viewModel: ArchitectureViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_architecture, container, false)
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_architecture,
            container,
            false
        )

        viewModel = ViewModelProviders.of(this).get(ArchitectureViewModel::class.java)
        binding.architectureViewModel = viewModel
        binding.lifecycleOwner= this

        binding.nextPage.setOnClickListener {

            val action = ArchitectureDirections.actionArchitectureToPageTwo((viewModel.liveValue.value)!!.plus(0))
            NavHostFragment.findNavController(this).navigate(action)
            Log.i("Architecture Fragment","Clicked The Next Page Button.")
        }

        return binding.root
    }


}
