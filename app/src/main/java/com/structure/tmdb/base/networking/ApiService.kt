package com.structure.tmdb.base.networking

import com.structure.tmdb.dashboard.dashboardmodels.MovieListItems
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import javax.inject.Inject

interface ApiService {
    @GET("movie/{filter}")
    suspend fun getMovies(
        @Path("filter") filter: String,
        @Query("api_key") apiKey: String
    ): Response< MovieListItems>
}
class  ApiServiceImp @Inject constructor(private  val apiService: ApiService) : ApiService
{

    override suspend fun getMovies(filter: String, apiKey: String): Response<MovieListItems> {
      return  apiService.getMovies(filter =filter, apiKey =apiKey)
    }

}