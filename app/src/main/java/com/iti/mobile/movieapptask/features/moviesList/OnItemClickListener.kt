package com.iti.mobile.movieapptask.features.moviesList

import com.iti.mobile.movieapptask.model.entities.Movie

interface OnItemClickListener {
    fun onClick(movie: Movie)
}