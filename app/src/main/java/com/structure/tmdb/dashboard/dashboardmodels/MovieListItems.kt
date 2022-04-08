package com.structure.tmdb.dashboard.dashboardmodels

import com.google.gson.annotations.SerializedName


data class MovieListItems(

    @SerializedName("page") val page: Int = 0,
    @SerializedName("results") val results: List<BaseListResponse>? = null,
    @SerializedName("total_pages") val total_pages: Int = 0,
    @SerializedName("total_results") val total_results: Int = 0,
)
