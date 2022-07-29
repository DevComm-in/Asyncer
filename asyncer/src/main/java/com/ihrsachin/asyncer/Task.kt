package com.ihrsachin.asyncer

interface Task {
    fun backgroundTask()
    fun onTaskCompletion()
}