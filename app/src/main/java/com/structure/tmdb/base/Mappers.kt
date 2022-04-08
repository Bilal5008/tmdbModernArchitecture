package com.structure.tmdb.base

import com.structure.tmdb.dashboard.dashboardmodels.MovieListInfoUI
import com.structure.tmdb.dashboard.dashboardmodels.MovieListItems


fun MovieListItems.toUI(): List<MovieListInfoUI> {
    var movieListInfoUI = mutableListOf<MovieListInfoUI>()

    results?.let {
        for (i in results.indices) {
            movieListInfoUI.add(
                MovieListInfoUI(
                    title = results[i].title,
                    overview = results[i].overview

                )
            )
        }
    }
    return movieListInfoUI

}