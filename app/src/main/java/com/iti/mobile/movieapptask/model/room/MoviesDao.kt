package com.iti.mobile.movieapptask.model.room

import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.iti.mobile.movieapptask.model.entities.Movie

@Dao
interface MoviesDao{

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(moviesList: List<Movie>)

    @Query("Select * from moviesTable")
    fun getAllMovies(): DataSource.Factory<Int, Movie>
}