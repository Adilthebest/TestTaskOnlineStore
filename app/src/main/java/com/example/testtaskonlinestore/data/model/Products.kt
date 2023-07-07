package com.example.testtaskonlinestore.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

class Products : ArrayList<ProductsItem>()
@Entity
data class ProductsItem(
    val category: String? = null,
    val description: String? = null,
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val image: String? = null,
    val price: Double? = null,
    val rating: Rating? = null,
    val title: String? = null
)

data class Rating(
    val count: Int? = null,
    val rate: Double? = null
)