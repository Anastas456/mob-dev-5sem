package com.example.laba3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.laba3.databinding.FragmentFirstBinding

class FirstFragment: Fragment() {

    private lateinit var binding: FragmentFirstBinding
    private val dataModel: DataModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater,container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentFirstBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.nextBtn.setOnClickListener{
            dataModel.num1.value = binding.inputNum1.text.toString()

            (activity as MainActivity?)!!.replaceFragment(SecondFragment(), "frag2")

        }
    }
}