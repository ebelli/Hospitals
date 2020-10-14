package com.ebelli.hospitals.di.modules

import com.ebelli.hospitals.ui.main.MainViewModel
import kotlinx.coroutines.Dispatchers
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        MainViewModel(get(), Dispatchers.IO)
    }
}