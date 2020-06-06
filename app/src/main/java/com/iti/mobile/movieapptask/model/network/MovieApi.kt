package com.iti.mobile.movieapptask.model.network

import com.iti.mobile.movieapptask.BuildConfig
import com.iti.mobile.movieapptask.model.entities.MoviesResponse
import com.iti.mobile.movieapptask.utils.POPULAR_MOVIES
import com.iti.mobile.movieapptask.utils.SEARCH
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi {
    @GET(POPULAR_MOVIES)
    suspend fun getMovies(
        @Query("api_key") apiKey: String = BuildConfig.Movie_App_API_KEY,
        @Query("page") pageNum: Int): MoviesResponse

    @GET(SEARCH)
    suspend fun searchMovie(
        @Query("api_key") apiKey: String = BuildConfig.Movie_App_API_KEY,
        @Query("query") query: String
    ): MoviesResponse
}