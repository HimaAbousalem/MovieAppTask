package com.iti.mobile.movieapptask.model.entities

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "MoviesTable")
data class Movie(
    @PrimaryKey
    var title: String,
    @field:Json(name= "poster_path")
    var posterPath: String? = "",
    @field:Json(name = "release_date")
    var releaseDate: String? = "",
    @field:Json(name= "vote_average")
    var voteAverage: Double? = 0.0,
    @field:Json(name= "overview")
    var overview: String? = ""
): Parcelable
