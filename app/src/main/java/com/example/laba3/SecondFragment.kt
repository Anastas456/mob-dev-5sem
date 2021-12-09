package com.example.laba3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.laba3.databinding.FragmentSecondBinding

class SecondFragment: Fragment() {
    private lateinit var binding: FragmentSecondBinding
    private val dataModel: DataModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentSecondBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.nextBtn.setOnClickListener{
            dataModel.num2.value = binding.inputNum2.text.toString()
            (activity as MainActivity?)!!.replaceFragment(ThirdFragment(), "frag3")
        }
        binding.backBtn.setOnClickListener{
            (activity as MainActivity?)!!.back()
        }
    }
}