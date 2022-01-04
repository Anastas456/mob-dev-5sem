package com.example.laba4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.laba4.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private val verticalLinearLayoutManager: LinearLayoutManager=
        LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        setRecycleView()
    }

    private fun setRecycleView(){
        binding.recyclerView.layoutManager = verticalLinearLayoutManager
        binding.recyclerView.adapter = Adapter(Holder.createPersonCollection(), ::showSnackbar, ::showLikeSnackbar)
    }

    private fun showSnackbar(person: Person): Unit{
        Snackbar.make(binding.root, "Нажата карточка "+person.name, 1500).show()
    }

    private fun showLikeSnackbar(person: Person): Unit{
        Snackbar.make(binding.root, "Нажат лайк "+person.name, 1500).show()
    }
}