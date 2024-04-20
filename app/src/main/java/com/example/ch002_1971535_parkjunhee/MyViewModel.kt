package com.example.ch002_1971535_parkjunhee

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel : ViewModel() {
    val countLiveData = MutableLiveData<Int>()

    init {
        countLiveData.value = 0;
    }

    fun increase() {
        countLiveData.value = (countLiveData.value ?: 0) + 1
    }
}