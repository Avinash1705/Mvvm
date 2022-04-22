package com.example.mvvm.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvm.Repositary.TodoRepositary
import com.example.mvvm.model.todoListModel
import kotlinx.coroutines.launch

class MainViewModel(private val repoTodo:TodoRepositary) :ViewModel(){
    val TAG = "skyDive"
    init {
        viewModelScope.launch {
            //funtion access
            Log.d(TAG, ": ")
            repoTodo.getTodoRepo(1)   //pass value if u want
        }
    }
    val quotes :LiveData<todoListModel>
    get() = repoTodo.quotes
}