package com.example.projetkotlin.presentation.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.projetkotlin.domain.usecase.CreateUserUseCase

class MainViewModel(val createUserUseCase: CreateUserUseCase) : ViewModel() {

    val counter: MutableLiveData<Int> = MutableLiveData()

    init {
        counter.value= 0

    }

    fun onClickedIncrement() {
        counter.value =  (counter.value ?: 0) + 1
    }

}