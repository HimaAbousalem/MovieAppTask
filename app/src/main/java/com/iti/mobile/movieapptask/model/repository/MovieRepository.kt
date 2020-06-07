package com.iti.mobile.movieapptask.model.repository

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.iti.mobile.movieapptask.model.entities.Movie
import com.iti.mobile.movieapptask.model.entities.MoviesResult
import com.iti.mobile.movieapptask.model.network.MovieApi
import com.iti.mobile.movieapptask.model.room.MoviesDao
import javax.inject.Inject

class MovieRepository @Inject constructor(private val movieDao: MoviesDao, private val movieApi: MovieApi){

    fun getAllMovies(): MoviesResult {
        val dataSourceFactory = movieDao.getAllMovies()

        val boundaryCallback = BoundaryCallback(movieApi, movieDao)
        val errorMessage = boundaryCallback.networkErrors
        val movies =  LivePagedListBuilder(dataSourceFactory, DATABASE_PAGE_SIZE)
            .setBoundaryCallback(boundaryCallback)
            .build()
        return MoviesResult(movies, errorMessage)
    }

    companion object {
        private const val DATABASE_PAGE_SIZE = 20
    }

}