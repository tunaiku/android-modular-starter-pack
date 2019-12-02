package com.godohdev.modular_architecture

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.godohdev.movies.Constants

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d("DATA_GUE","DATA "+Constants.getString())
    }
}
