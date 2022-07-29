package com.ihrsachin.asyncer

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class Asyncer : CoroutineTask{
    lateinit var task : Task
    fun init(task: Task) {
        this.task = task
        CoroutineScope(Dispatchers.IO).launch { doInBackground() }
    }

    override suspend fun doInBackground() {
        task.backgroundTask()
        onComplete()
    }

    override suspend fun onComplete() {
        withContext(Main){
            task.onTaskCompletion()
        }
    }

}