package com.raiztech.tmdbreiztech.dashboard.moviesusecase

import com.raiztech.tmdbreiztech.dashboard.dashboardrepo.MoviesRepository
import javax.inject.Inject

interface FetchPopularMoviesUseCase {
    suspend operator fun invoke(filter:String)
}

class FetchPopularMoviesUseCaseImpl @Inject constructor(private val moviesRepository: MoviesRepository) : FetchPopularMoviesUseCase {

    override suspend fun invoke(filter:String) {
        moviesRepository.getMovieList(filter =filter )
    }

}