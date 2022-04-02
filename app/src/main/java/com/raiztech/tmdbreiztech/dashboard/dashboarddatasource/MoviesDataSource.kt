package com.raiztech.tmdbreiztech.dashboard.dashboarddatasource

import com.raiztech.tmdbreiztech.base.AppConstants
import com.raiztech.tmdbreiztech.base.networking.ApiResult
import com.raiztech.tmdbreiztech.base.networking.ApiService
import com.raiztech.tmdbreiztech.base.networking.BaseDataSource
import com.raiztech.tmdbreiztech.dashboard.dashboardmodels.MovieListItems
import javax.inject.Inject

interface MoviesDataSource {
    suspend fun getMovieList(filter: String): ApiResult<MovieListItems>
}

class MoviesDataSourceImpl @Inject constructor(private val service: ApiService) : MoviesDataSource , BaseDataSource() {

    override suspend fun getMovieList(filter: String): ApiResult<MovieListItems>  = getResult{

         service.getMovies(filter = filter, apiKey = AppConstants.API_TOKEN)

    }
}