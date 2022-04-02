package com.raiztech.tmdbreiztech.base

import com.raiztech.tmdbreiztech.dashboard.dashboardmodels.MovieListInfoUI
import com.raiztech.tmdbreiztech.dashboard.dashboardmodels.MovieListItems


fun MovieListItems.toUI(): MovieListInfoUI {
    val movieResult = results.elementAt(1)
    return MovieListInfoUI(
        title = movieResult.title,
        overview = movieResult.overview

    )
}