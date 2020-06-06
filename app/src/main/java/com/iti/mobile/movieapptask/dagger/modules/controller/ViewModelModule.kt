package com.iti.mobile.movieapptask.dagger.modules.controller

import androidx.lifecycle.ViewModel
import com.iti.mobile.movieapptask.dagger.scopes.ViewModelKey
import com.iti.mobile.movieapptask.features.moviesList.MoviesViewModel

import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(MoviesViewModel::class)
    internal abstract fun mainViewModel(viewModel: MoviesViewModel): ViewModel
}