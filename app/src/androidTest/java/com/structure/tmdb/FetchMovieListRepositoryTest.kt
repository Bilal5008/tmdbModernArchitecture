package com.structure.tmdb

import com.structure.tmdb.base.networking.ApiService
import com.structure.tmdb.dashboard.dashboarddatasource.MoviesDataSource
import com.structure.tmdb.dashboard.dashboarddatasource.MoviesDataSourceImpl
import kotlinx.coroutines.runBlocking
import org.junit.Test

class FetchMovieListRepositoryTest
{
    @Test
    fun testFetchMovieListByCategory() = runBlocking {
        val result = getMovieListDataSource(service =  )
    }

    private fun getMovieListDataSource(  service: ApiService): MoviesDataSource  = MoviesDataSourceImpl {

    }

}