package com.raiztech.tmdbreiztech.dashboard.moviesusecase

import com.raiztech.tmdbreiztech.base.toUI
import com.raiztech.tmdbreiztech.dashboard.dashboardmodels.MovieListInfoResult
import com.raiztech.tmdbreiztech.dashboard.dashboardmodels.MovieListInfoUIResult
import com.raiztech.tmdbreiztech.dashboard.dashboardrepo.MoviesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

interface GetPopularMoviesUseCase {
     operator fun invoke(filter: String): Flow<MovieListInfoUIResult>
}

class GetPopularMoviesUseCaseImpl @Inject constructor(private val moviesRepository: MoviesRepository) : GetPopularMoviesUseCase {
    override  fun invoke(filter: String): Flow<MovieListInfoUIResult> =
        moviesRepository.getMovieResult(filter = filter).map { result  ->
            when(result)
            {
                is MovieListInfoResult.Success -> if (result.data.results.size >1)
                    MovieListInfoUIResult.Success(result.data.toUI())

                else MovieListInfoUIResult.Error(errorMessage = "Try Again")

                is MovieListInfoResult.Error ->MovieListInfoUIResult.Error(errorMessage = result.errorMessage)

                is MovieListInfoResult.Loading ->  MovieListInfoUIResult.Loading
            }
        }

}