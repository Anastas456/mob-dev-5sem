package com.example.laba3

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DataModel: ViewModel() {
    val num1: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    val num2: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    val operation: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
}