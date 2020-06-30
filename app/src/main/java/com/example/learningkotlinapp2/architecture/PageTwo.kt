package com.example.learningkotlinapp2.architecture


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil

import com.example.learningkotlinapp2.R
import com.example.learningkotlinapp2.databinding.FragmentPageTwoBinding

class PageTwo : Fragment() {
    private lateinit var binding: FragmentPageTwoBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_page_two, container, false)
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_page_two,
            container,
            false
        )

//        setting the value for the Page Two.
//        binding.score.text = PageTwoArgs.fromBundle(requireArguments()).score.toString()
        binding.score.text = PageTwoArgs.fromBundle(requireArguments()).score.toString()
        return binding.root
    }


}
