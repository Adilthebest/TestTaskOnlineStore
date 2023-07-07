package com.example.testtaskonlinestore.data.remote

import com.example.testtaskonlinestore.data.model.Products
import com.example.testtaskonlinestore.data.model.ProductsItem
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("category/jewelery")
    suspend fun getJewelery(): Products

    @GET("category/electronics")
    suspend fun getElectronics(): Products

    @GET("category/men's clothing")
    suspend fun getMensClothing(): Products

    @GET("category/women's clothing")
    suspend fun getWomensClothing(): Products

    @GET("{id}")
    suspend fun getId(
        @Path("id") id: Int
    ): ProductsItem
}