package com.example.mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.example.mvvm.ApiInterface.ApiService
import com.example.mvvm.Application.TodoApplication
import com.example.mvvm.Repositary.TodoRepositary
import com.example.mvvm.RetrofitHelper.RetrofitHelp
import com.example.mvvm.viewModel.MainViewModel
import com.example.mvvm.viewModel.MainViewModelFactory

class MainActivity : AppCompatActivity() {
lateinit var mainViewModel: MainViewModel
val TAG = "skyDive"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //repo
//        val apiService = RetrofitHelp.getClient()!!.create(ApiService::class.java)
//        val repositary = TodoRepositary(apiService)
        //by application
        val repo =(application as TodoApplication).quoteRepo
         mainViewModel = ViewModelProvider(this,MainViewModelFactory(repo))[MainViewModel::class.java]



    //put observer on live data 
        mainViewModel.quotes.observe(this,{
            Log.d(TAG, "onCreate:${it[1]} ")
        })
    
    }

}