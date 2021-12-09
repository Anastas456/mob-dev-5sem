package com.example.laba3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import com.example.laba3.databinding.FragmentFourthBinding

class FourthFragment: Fragment() {
    private lateinit var binding: FragmentFourthBinding
    private  val  dataModel: DataModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentFourthBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        var result: Double = 0.0

        super.onViewCreated(view, savedInstanceState)

        dataModel.num1.observe(activity as LifecycleOwner, {
            binding.displayNum1.text = it
        })
        dataModel.num2.observe(activity as LifecycleOwner, {
            binding.displayNum2.text = it
        })
        dataModel.operation.observe(activity as LifecycleOwner, {
            binding.displayOperation.text = it
        })

        if (dataModel.operation.value == "+"){
            result = dataModel.num1.value!!.toDouble() + dataModel.num2.value!!.toDouble()
        }
        if (dataModel.operation.value == "-"){
            result = dataModel.num1.value!!.toDouble() - dataModel.num2.value!!.toDouble()
        }
        if (dataModel.operation.value == "*"){
            result = dataModel.num1.value!!.toDouble() * dataModel.num2.value!!.toDouble()
        }
        if (dataModel.operation.value == "/"){
            result = dataModel.num1.value!!.toDouble() / dataModel.num2.value!!.toDouble()
        }

        binding.displayResult.text = result.toString()

    }
}