package com.example.testtaskonlinestore.repository

import com.example.testtaskonlinestore.data.base.BaseRepository
import com.example.testtaskonlinestore.data.remote.ApiService

class Repository(val apiService: ApiService) : BaseRepository() {
    fun getJewelery(sort: String) = doReguest {
        apiService.getJewelery()
    }

    fun getElectronics(sort: String) = doReguest {
        apiService.getElectronics()
    }

    fun getMensClothing(sort: String) = doReguest {
        apiService.getMensClothing()
    }

    fun getWomensClothing(sort: String) = doReguest {
        apiService.getWomensClothing()
    }
    fun getProductId(id: Int) = doReguest {
        apiService.getId(id)
    }
}