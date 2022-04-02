package com.raiztech.tmdbreiztech.base.networking

import com.raiztech.tmdbreiztech.dashboard.dashboardmodels.MovieListItems
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("movie/{filter}")
    suspend fun getMovies(
        @Path("filter") filter: String,
        @Query("api_key") apiKey: String
    ): Response< MovieListItems>
}