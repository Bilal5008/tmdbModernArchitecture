package com.raiztech.tmdbreiztech.dashboard.dashboardfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.raiztech.tmdbreiztech.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NowPlayingMoviesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_now_playing_movies, container, false)
    }

}