package com.iti.mobile.movieapptask.model.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.iti.mobile.movieapptask.model.entities.Movie

@Database(
    entities = [Movie::class],
    version = 1,
    exportSchema = false)
abstract class MoviesDatabase : RoomDatabase() {
    abstract val movieDao : MoviesDao
}