package com.raiztech.tmdbreiztech.dashboard.dashboardmodels

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize


data class MovieListItems(

    @SerializedName("page") val page: Int = 0,
    @SerializedName("results") val results: List<BaseListResponse> = listOf(),
    @SerializedName("total_pages") val total_pages: Int = 0,
    @SerializedName("total_results") val total_results: Int = 0,
)
