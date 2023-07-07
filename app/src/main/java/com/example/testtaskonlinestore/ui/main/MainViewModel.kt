package com.example.testtaskonlinestore.ui.main

import com.example.testtaskonlinestore.data.model.Products
import com.example.testtaskonlinestore.repository.Repository
import com.example.testtaskonlinestore.ui.base.BaseViewModel
import com.example.testtaskonlinestore.utils.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class MainViewModel(val repository: Repository) : BaseViewModel() {
    val _stateJewelery = MutableStateFlow<UiState<Products>>(UiState.Empty())
    val stateJewelery = _stateJewelery.asStateFlow()

    val _stateElectronics = MutableStateFlow<UiState<Products>>(UiState.Empty())
    val stateElectronics = _stateElectronics.asStateFlow()

    val _stateMensClothing = MutableStateFlow<UiState<Products>>(UiState.Empty())
    val stateMensClothing = _stateMensClothing.asStateFlow()

    val _stateWomensClothing = MutableStateFlow<UiState<Products>>(UiState.Empty())
    val stateWomensClothing = _stateWomensClothing.asStateFlow()

    fun getJewelery(sort: String) = repository.getJewelery(sort).collectFlow(_stateJewelery)

    fun getElectronics(sort: String) =
        repository.getElectronics(sort).collectFlow(_stateElectronics)

    fun getMensClothing(sort: String) =
        repository.getMensClothing(sort).collectFlow(_stateMensClothing)

    fun getWomensClothing(sort: String) =
        repository.getWomensClothing(sort).collectFlow(_stateWomensClothing)

}

