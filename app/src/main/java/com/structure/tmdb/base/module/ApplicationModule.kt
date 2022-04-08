package com.structure.tmdb.base.module


import com.structure.tmdb.base.AppConstants
import com.structure.tmdb.base.networking.ApiService
import com.structure.tmdb.dashboard.dashboarddatasource.MoviesDataSource
import com.structure.tmdb.dashboard.dashboarddatasource.MoviesDataSourceImpl
import com.structure.tmdb.dashboard.dashboardrepo.MoviesRepository
import com.structure.tmdb.dashboard.dashboardrepo.MoviesRepositoryImpl
import com.structure.tmdb.dashboard.moviesusecase.FetchPopularMoviesUseCase
import com.structure.tmdb.dashboard.moviesusecase.FetchPopularMoviesUseCaseImpl
import com.structure.tmdb.dashboard.moviesusecase.GetPopularMoviesUseCase
import com.structure.tmdb.dashboard.moviesusecase.GetPopularMoviesUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ApplicationModule {


    private fun provideBaseUrl() = AppConstants.baseURL


    private fun provideRetrofit(): Retrofit =
        Retrofit.Builder()
            .baseUrl(provideBaseUrl())
            .client(OkHttpClient.Builder().build())
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    @Singleton
    fun provideApiService(): ApiService = provideRetrofit().create(ApiService::class.java)

    @Provides
    @Singleton
    fun provideMoviesDataSource(): MoviesDataSource = MoviesDataSourceImpl(
        service = provideApiService()
    )

    @Provides
    @Singleton
    fun provideMoviesRepository(): MoviesRepository = MoviesRepositoryImpl(
        moviesDataSource = provideMoviesDataSource()
    )



}

//Usecases
@Module
@InstallIn(SingletonComponent::class)
abstract class UseCaseModule {

    @Binds
    abstract fun bindFetchPopularMoviesUseCase(impl: FetchPopularMoviesUseCaseImpl): FetchPopularMoviesUseCase

    @Binds
    abstract fun bindGetPopularMoviesCase(impl: GetPopularMoviesUseCaseImpl): GetPopularMoviesUseCase
}


