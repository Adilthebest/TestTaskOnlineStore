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

    private val _getAllProductSearch = MutableStateFlow<String?>(null)
    val getAllProductSearch = _getAllProductSearch.asStateFlow()

    fun getJewelery() = repository.getJewelery(_getAllProductSearch.value).collectFlow(_stateJewelery)

    fun getElectronics() =
        repository.getElectronics(_getAllProductSearch.value).collectFlow(_stateElectronics)

    fun getMensClothing() =
        repository.getMensClothing(_getAllProductSearch.value).collectFlow(_stateMensClothing)

    fun getWomensClothing() =
        repository.getWomensClothing(_getAllProductSearch.value).collectFlow(_stateWomensClothing)

    fun getAllSearchQuery(newQuery: String?) {
        _getAllProductSearch.value = newQuery
    }
}

