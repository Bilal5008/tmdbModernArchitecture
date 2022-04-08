package com.structure.tmdb.base.networking

import retrofit2.Response


/**
 * Abstract Base Data source class with error handling
 */
abstract class BaseDataSource {

    protected suspend fun <T> getResult(call: suspend () -> Response<T>) = try {
        handleResponse(call())
    } catch (e: Throwable) {
        handleError<T>(e)
    }

    private fun <T> handleError(e: Throwable): ApiResult.Error<T> {
        return ApiResult.Error(
            message = e.message ?: "",
            error = ApiError(
                message = e.message ?: "",
                type = e.javaClass.name
            )
        )
    }

    private fun <T> handleResponse(response: Response<T>): ApiResult<T> {
        if (response.isSuccessful) {
            val body = response.body()
            return if (body != null) ApiResult.Success(body)
            else ApiResult.Error("Unknown error", ApiError(message = "Unknown Error"))
        }
        return buildApiError(response)
    }

    private fun <T> buildApiError(error: Response<T>): ApiResult<T> {

        return ApiResult.Error(error.message(), ApiError("Api Response Error",error.toString(),"You cannot see me"))
    }
}

