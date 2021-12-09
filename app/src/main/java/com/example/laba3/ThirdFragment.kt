package com.example.laba3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.laba3.databinding.FragmentThirdBinding

class ThirdFragment: Fragment() {
    private lateinit var binding: FragmentThirdBinding
    private val dataModel: DataModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentThirdBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.nextBtn.setOnClickListener{
            dataModel.operation.value = binding.inputOperation.text.toString()
            (activity as MainActivity?)!!.replaceFragment(FourthFragment(), "frag4")
        }

        binding.backBtn.setOnClickListener{
            (activity as MainActivity?)!!.back()

        }
    }
}