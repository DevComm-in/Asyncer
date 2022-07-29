package com.ihrsachin.asyncer

interface CoroutineTask {
    suspend fun doInBackground()
    suspend fun onComplete()
}