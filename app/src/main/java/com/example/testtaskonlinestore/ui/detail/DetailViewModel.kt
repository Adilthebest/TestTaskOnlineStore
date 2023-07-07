package com.example.testtaskonlinestore.ui.detail

import com.example.testtaskonlinestore.data.model.ProductsItem
import com.example.testtaskonlinestore.repository.Repository
import com.example.testtaskonlinestore.ui.base.BaseViewModel
import com.example.testtaskonlinestore.utils.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class DetailViewModel(
    private val repository: Repository
    ):BaseViewModel() {
    val _state = MutableStateFlow<UiState<ProductsItem>>(UiState.Empty())
    val state = _state.asStateFlow()

    fun getProductId(id: Int) {
        repository.getProductId(id).collectFlow(_state)
    }
}