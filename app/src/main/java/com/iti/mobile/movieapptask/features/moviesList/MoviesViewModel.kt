package com.iti.mobile.movieapptask.features.moviesList

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.paging.PagedList
import com.iti.mobile.movieapptask.model.entities.Movie
import com.iti.mobile.movieapptask.model.repository.MovieRepository
import javax.inject.Inject

class MoviesViewModel @Inject constructor(private val repo: MovieRepository): ViewModel(){

    var moviesData: LiveData<PagedList<Movie>> =  repo.getAllMovies()
}