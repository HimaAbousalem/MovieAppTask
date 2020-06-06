package com.iti.mobile.movieapptask.model.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.iti.mobile.movieapptask.model.entities.Movie
import com.iti.mobile.movieapptask.model.network.MovieApi
import com.iti.mobile.movieapptask.model.room.MoviesDao
import javax.inject.Inject

class MovieRepository @Inject constructor(private val movieDao: MoviesDao, private val movieApi: MovieApi){

    fun getAllMovies(): LiveData<PagedList<Movie>> {
        val dataSourceFactory = movieDao.getAllMovies()

        val boundaryCallback = BoundaryCallback(movieApi, movieDao)

        return LivePagedListBuilder(dataSourceFactory, DATABASE_PAGE_SIZE)
            .setBoundaryCallback(boundaryCallback)
            .build()
    }

    companion object {
        private const val DATABASE_PAGE_SIZE = 20
    }

}