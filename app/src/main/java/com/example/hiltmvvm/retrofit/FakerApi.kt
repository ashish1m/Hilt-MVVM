package com.example.hiltmvvm.retrofit

import com.example.hiltmvvm.model.Product
import retrofit2.Response
import retrofit2.http.GET

interface FakerApi {

    companion object {
        const val products = "/products"
    }

    @GET(products)
    suspend fun getProducts(): Response<List<Product>>
}