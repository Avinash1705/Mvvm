package com.example.mvvm.Application

import android.app.Application
import com.example.mvvm.ApiInterface.ApiService
import com.example.mvvm.Repositary.TodoRepositary
import com.example.mvvm.RetrofitHelper.RetrofitHelp

class TodoApplication : Application() {
    lateinit var quoteRepo :TodoRepositary
    override fun onCreate() {
        init()
        super.onCreate()
    }

    private fun init() {
        val apiService = RetrofitHelp.getClient()!!.create(ApiService::class.java)
        quoteRepo = TodoRepositary(apiService)
    }
}