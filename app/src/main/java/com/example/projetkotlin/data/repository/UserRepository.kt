package com.example.projetkotlin.data.repository

import com.example.projetkotlin.data.local.Database.DatabaseDao
import com.example.projetkotlin.data.local.toData
import com.example.projetkotlin.data.local.toEntity
import com.example.projetkotlin.domain.entity.User

class UserRepository (
    private val databaseDao: DatabaseDao
) {


    suspend fun createUser(user: User){
        databaseDao.insert(user.toData())
    }

    fun getUser(email: String) : User? {
        val userLocal = databaseDao.findByName(email)
        return userLocal.toEntity()
    }

}