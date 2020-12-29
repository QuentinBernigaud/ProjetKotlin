package com.example.projetkotlin.injection

import com.example.projetkotlin.presentation.main.MainViewModel
import org.koin.dsl.module


val presentationModule = module {

    factory { MainViewModel() }

}
