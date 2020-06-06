package com.iti.mobile.movieapptask.features.moviesList

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import com.iti.mobile.movieapptask.R
import com.iti.mobile.movieapptask.model.entities.Movie
import com.iti.mobile.movieapptask.utils.TMDB_IMAGEURL
import kotlinx.android.synthetic.main.movie_row.view.*

class MoviesAdapter(private val listener: OnItemClickListener): PagedListAdapter<Movie, MoviesAdapter.MoviesViewHolder>(MoviesDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        MoviesViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.movie_row, parent, false))

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        holder.setMovieImage(getItem(position))
    }

    inner class MoviesViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        init {
            itemView.movieImage.setOnClickListener{
                listener.onClick(getItem(absoluteAdapterPosition)!!)
            }
        }
        fun setMovieImage(movie: Movie?){
            movie?.let{
                it.posterPath?.let{ poster->
                    itemView.movieImage.load(TMDB_IMAGEURL+poster)
                }
            }
        }
    }

}

private class MoviesDiffCallback : DiffUtil.ItemCallback<Movie>() {

    override fun areItemsTheSame(
        oldItem: Movie,
        newItem: Movie
    ): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(
        oldItem: Movie,
        newItem: Movie
    ): Boolean {
        return oldItem == newItem
    }
}