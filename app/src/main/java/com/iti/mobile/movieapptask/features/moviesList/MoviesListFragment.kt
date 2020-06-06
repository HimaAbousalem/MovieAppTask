package com.iti.mobile.movieapptask.features.moviesList

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import com.iti.mobile.movieapptask.R
import com.iti.mobile.movieapptask.dagger.modules.controller.ControllerModule
import com.iti.mobile.movieapptask.databinding.FragmentMoviesListBinding
import com.iti.mobile.movieapptask.features.base.MovieApplication
import com.iti.mobile.movieapptask.features.base.ViewModelProviderFactory
import com.iti.mobile.movieapptask.model.entities.Movie
import javax.inject.Inject

class MoviesListFragment : Fragment(), OnItemClickListener {

    private val adapter: MoviesAdapter by lazy {MoviesAdapter(this)}
    @Inject
    lateinit var viewModelProvider: ViewModelProviderFactory
    lateinit var viewModel: MoviesViewModel
    private lateinit var binding: FragmentMoviesListBinding
    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMoviesListBinding.inflate(layoutInflater)
        (activity?.application as MovieApplication).appComponent.controllerComponent(
            ControllerModule( activity as AppCompatActivity)
        ).inject(this)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        viewModel = viewModelProvider.create(MoviesViewModel::class.java)

        binding.moviesRecycler.apply{
            layoutManager = GridLayoutManager(context, 2)
            adapter = this@MoviesListFragment.adapter
        }

        viewModel.moviesData.observe(requireActivity(), Observer {
            if(it.isNotEmpty())
                adapter.submitList(it)
        })
    }

    override fun onClick(movie: Movie) {
        val data = MoviesListFragmentDirections.actionMoviesListFragmentToMovieDetailsFragment(movie)
        navController.navigate(data)
    }
}