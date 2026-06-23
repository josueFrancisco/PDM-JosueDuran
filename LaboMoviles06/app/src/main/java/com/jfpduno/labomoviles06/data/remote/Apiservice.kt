package com.jfpduno.labomoviles06.data.remote

import com.jfpduno.labomoviles06.model.Meals
import retrofit2.http.GET

interface ApiService {

    @GET("https://www.themealdb.com/api/json/v1/1/search.php?s=")
    suspend fun getUsers(): Meals
}