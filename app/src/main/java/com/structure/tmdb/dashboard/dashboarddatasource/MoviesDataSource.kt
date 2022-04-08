package com.structure.tmdb.dashboard.dashboarddatasource

import com.structure.tmdb.base.AppConstants
import com.structure.tmdb.base.networking.ApiResult
import com.structure.tmdb.base.networking.ApiService
import com.structure.tmdb.base.networking.BaseDataSource
import com.structure.tmdb.dashboard.dashboardmodels.MovieListItems
import javax.inject.Inject

interface MoviesDataSource {
    suspend fun getMovieList(filter: String): ApiResult<MovieListItems>
}

class MoviesDataSourceImpl @Inject constructor(private val service: ApiService) : MoviesDataSource , BaseDataSource() {

    override suspend fun getMovieList(filter: String): ApiResult<MovieListItems>  = getResult{

         service.getMovies(filter = filter, apiKey = AppConstants.API_TOKEN)

    }
}