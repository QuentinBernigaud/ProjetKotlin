package com.example.projetkotlin.injection

import android.content.Context
import androidx.room.Room
import com.example.projetkotlin.data.local.Database.AppDatabase
import com.example.projetkotlin.data.local.Database.DatabaseDao
import com.example.projetkotlin.data.repository.UserRepository
import com.example.projetkotlin.domain.usecase.CreateUserUseCase
import com.example.projetkotlin.domain.usecase.GetUserUseCase
import com.example.projetkotlin.presentation.main.MainViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import java.security.AccessControlContext


val presentationModule = module {

    factory { MainViewModel(get(), get()) }

}

val domainModule = module {

    factory { CreateUserUseCase(get()) }
    factory { GetUserUseCase(get()) }


}

val dataModule = module {

    single { UserRepository(get()) }
    single { createDataBase(androidContext()) }

}

fun createDataBase(context: Context): DatabaseDao {
    val appDatabase = Room.databaseBuilder(
        context,
        AppDatabase::class.java, "database-name"
    ).build()
    return appDatabase.databaseDao()

}