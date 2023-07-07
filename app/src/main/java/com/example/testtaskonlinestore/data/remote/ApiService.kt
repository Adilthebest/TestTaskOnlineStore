package com.example.testtaskonlinestore.data.remote

import com.example.testtaskonlinestore.data.model.Products
import com.example.testtaskonlinestore.data.model.ProductsItem
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("category/jewelery")
    suspend fun getJewelery(
        @Query("sort") sort:String?
    ): Products

    @GET("category/electronics")
    suspend fun getElectronics(
        @Query("sort") sort:String?
    ): Products

    @GET("category/men's clothing")
    suspend fun getMensClothing(
        @Query("sort") sort:String?
    ): Products

    @GET("category/women's clothing")
    suspend fun getWomensClothing(
        @Query("sort") sort:String?
    ): Products

    @GET("{id}")
    suspend fun getId(
        @Path("id") id: Int
    ): ProductsItem
}