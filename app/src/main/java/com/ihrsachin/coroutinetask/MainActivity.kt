package com.ihrsachin.coroutinetask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.Toast
import com.ihrsachin.asyncer.Asyncer
import com.ihrsachin.asyncer.Task

class MainActivity : AppCompatActivity() {

    private lateinit var btn : Button
    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn = findViewById(R.id.btn)
        progressBar = findViewById(R.id.progress_bar)


        btn.setOnClickListener{
            onClick()
        }

    }

    private fun onClick(){
        progressBar.visibility = View.VISIBLE
        Asyncer().init(object : Task {
            override fun backgroundTask() {
                for(i in 1..100000){
                    Log.d("count", "backgroundTask: $i")
                }
            }

            override fun onTaskCompletion() {
                progressBar.visibility = View.GONE
                Toast.makeText(this@MainActivity, "Done", Toast.LENGTH_SHORT).show()
                Log.d("TAG", "onTaskCompletion")
            }
        })
    }

}