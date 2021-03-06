package com.iti.mobile.movieapptask.model.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.PagedList
import com.iti.mobile.movieapptask.model.entities.Movie
import com.iti.mobile.movieapptask.model.network.MovieApi
import com.iti.mobile.movieapptask.model.room.MoviesDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class BoundaryCallback @Inject constructor(
    private val movieApi: MovieApi,
    private val movieDao: MoviesDao
) : PagedList.BoundaryCallback<Movie>() {

    private var lastRequestedPage = 1
    private var isRequestInProgress = false

    private val _networkErrors = MutableLiveData<String>()
    val networkErrors: LiveData<String>
        get() = _networkErrors

    override fun onZeroItemsLoaded() {
        requestAndSaveData()
    }

    override fun onItemAtEndLoaded(itemAtEnd: Movie) {
        requestAndSaveData()
    }

    private fun requestAndSaveData() {
        if (isRequestInProgress) return

        isRequestInProgress = true
        CoroutineScope(Dispatchers.IO).launch{
            isRequestInProgress = try {
                val movieResponse = movieApi.getMovies(pageNum = lastRequestedPage)
                movieDao.insertAll(movieResponse.results)
                lastRequestedPage++
                false
            }catch (e:Exception){
                _networkErrors.postValue("No Internet Connection")
                false
            }
        }
    }
}