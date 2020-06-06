package com.iti.mobile.movieapptask.features.moviesDetails

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import coil.api.load
import com.iti.mobile.movieapptask.R
import com.iti.mobile.movieapptask.databinding.FragmentMovieDetailsBinding
import com.iti.mobile.movieapptask.databinding.FragmentMoviesListBinding
import com.iti.mobile.movieapptask.features.base.ViewModelProviderFactory
import com.iti.mobile.movieapptask.features.moviesList.MoviesAdapter
import com.iti.mobile.movieapptask.features.moviesList.MoviesViewModel
import com.iti.mobile.movieapptask.model.entities.Movie
import com.iti.mobile.movieapptask.utils.TMDB_IMAGEURL
import javax.inject.Inject

class MovieDetailsFragment : Fragment() {

    private lateinit var binding: FragmentMovieDetailsBinding
    private val args: MovieDetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMovieDetailsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val movie = args.movieObject
        setData(movie)
    }

    private fun setData(movie: Movie) {
        binding.moviePicture.load(TMDB_IMAGEURL + movie.posterPath)
        binding.movieTitle.text = movie.title
        binding.releaseDate.text = movie.releaseDate
        binding.overviewMovie.text = movie.overview
    }

}