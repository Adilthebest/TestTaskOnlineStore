package com.example.testtaskonlinestore.repository

import com.example.testtaskonlinestore.data.base.BaseRepository
import com.example.testtaskonlinestore.data.remote.ApiService

class Repository(val apiService: ApiService) : BaseRepository() {
    fun getJewelery(sort: String?) = doReguest {
        apiService.getJewelery(sort)
    }

    fun getElectronics(sort: String?) = doReguest {
        apiService.getElectronics(sort)
    }

    fun getMensClothing(sort: String?) = doReguest {
        apiService.getMensClothing(sort)
    }

    fun getWomensClothing(sort: String?) = doReguest {
        apiService.getWomensClothing(sort)
    }
    fun getProductId(id: Int) = doReguest {
        apiService.getId(id)
    }
}