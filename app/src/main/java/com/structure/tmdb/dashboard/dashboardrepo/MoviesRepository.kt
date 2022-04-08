package com.structure.tmdb.dashboard.dashboardrepo

import com.structure.tmdb.base.networking.ApiResult
import com.structure.tmdb.dashboard.dashboarddatasource.MoviesDataSource
import com.structure.tmdb.dashboard.dashboardmodels.MovieListInfoResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.withContext
import javax.inject.Inject

interface MoviesRepository {
    suspend fun getMovieList(filter: String)
    fun getMovieResult(filter: String): Flow<MovieListInfoResult>
}

class MoviesRepositoryImpl @Inject constructor(private val moviesDataSource: MoviesDataSource) : MoviesRepository {
    private val movieResult = hashMapOf<String, MutableStateFlow<MovieListInfoResult>>()

    override suspend fun getMovieList(filter: String) {
        withContext(Dispatchers.IO)
        {
            moviesDataSource.getMovieList(filter).let { result ->
                when (result) {
                    is ApiResult.Success -> {
                        getMovieResultInternal(filter).emit(
                            MovieListInfoResult.Success(result.data)
                        )
                    }
                    is ApiResult.Error -> {
                        getMovieResultInternal(filter).emit(
                            MovieListInfoResult.Error(errorMessage = result.message)
                        )
                    }
                }
            }

        }
    }

    override fun getMovieResult(filter: String): Flow<MovieListInfoResult> = getMovieResultInternal(filter = filter)

    private fun getMovieResultInternal(filter: String): MutableStateFlow<MovieListInfoResult> =
        movieResult.getOrPut(filter) { MutableStateFlow(MovieListInfoResult.Loading) }


}