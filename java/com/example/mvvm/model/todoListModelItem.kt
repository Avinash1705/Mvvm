package com.example.mvvm.model

data class todoListModelItem(
    val completed: Boolean,
    val id: Int,
    val title: String,
    val userId: Int
)