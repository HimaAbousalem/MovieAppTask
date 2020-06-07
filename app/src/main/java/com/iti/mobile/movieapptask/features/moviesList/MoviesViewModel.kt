package com.iti.mobile.movieapptask.features.moviesList

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.iti.mobile.movieapptask.model.entities.Movie
import com.iti.mobile.movieapptask.model.entities.MoviesResult
import com.iti.mobile.movieapptask.model.repository.MovieRepository
import javax.inject.Inject

class MoviesViewModel @Inject constructor(repo: MovieRepository): ViewModel(){

    private val repoResult: LiveData<MoviesResult> = MutableLiveData(repo.getAllMovies())

    val moviesData: LiveData<PagedList<Movie>> =  Transformations.switchMap(repoResult){
        it.data
    }

    val networkErrors: LiveData<String> = Transformations.switchMap(repoResult) { it ->
        it.networkErrors
    }

}