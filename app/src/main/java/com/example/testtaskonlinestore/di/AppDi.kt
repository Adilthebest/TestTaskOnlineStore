package com.example.testtaskonlinestore.di

import com.example.testtaskonlinestore.repository.Repository
import com.example.testtaskonlinestore.ui.detail.DetailViewModel
import com.example.testtaskonlinestore.ui.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
viewModel { MainViewModel(get()) }
viewModel { DetailViewModel(get()) }
    single { Repository(get ()) }
}