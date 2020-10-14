package com.ebelli.hospitals.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ebelli.hospitals.R
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val mainViewModel : MainViewModel by viewModel()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainViewModel.getHospitals()
    }
}