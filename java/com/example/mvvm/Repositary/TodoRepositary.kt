package com.example.mvvm.Repositary

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mvvm.ApiInterface.ApiService
import com.example.mvvm.model.todoListModel

class TodoRepositary(private val apiService: ApiService) {
private val TAG = "skyDive"
    private val repoLiveData = MutableLiveData<todoListModel>()

   suspend fun getTodoRepo(page :Int){
        val repo = apiService.getTodos(page)
        val call = repo.body()
        if(call != null){
            repoLiveData.postValue(call)
            Log.d(TAG, "getTodoRepo: Success")
        }
        else{
            Log.d(TAG, "getTodoRepo: Fail $repo")
        }
    }
    val quotes :LiveData<todoListModel>
    get() = repoLiveData

}