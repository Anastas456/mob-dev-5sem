package com.example.laba3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import com.example.laba3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val dataModel: DataModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)


        val firstFragment = FirstFragment()
        val transaction = supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragmentBlock, firstFragment)
        transaction.commit()

        dataModel.num1.observe(this, {

        })

        binding.btn1.setOnClickListener{
            replaceFragment(FirstFragment(), "frag1")
        }
        binding.btn2.setOnClickListener{
            replaceFragment(SecondFragment(), "frag2")
        }
        binding.btn3.setOnClickListener{
            replaceFragment(ThirdFragment(), "frag3")
        }
        binding.btn4.setOnClickListener{
            replaceFragment(FourthFragment(), "frag4")
        }

    }


    fun replaceFragment(fragment: Fragment, name: String){
        val transaction = supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragmentBlock, fragment)
            .addToBackStack(name)
        transaction.commit()
    }

    fun back(){
        supportFragmentManager.popBackStack()
    }



}