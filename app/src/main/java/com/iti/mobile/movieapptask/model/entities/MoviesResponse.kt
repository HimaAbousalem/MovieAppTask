package com.iti.mobile.movieapptask.model.entities

import com.squareup.moshi.Json

data class MoviesResponse(
    @field:Json(name = "page")
    var page: Int,

    @field:Json(name ="total_results")
    var totalResults: Int,

    @field:Json(name ="total_pages")
    var totalPages: Int,

    @field:Json(name ="results")
    var results: List<Movie>
)