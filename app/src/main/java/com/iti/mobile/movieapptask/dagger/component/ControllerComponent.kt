package com.iti.mobile.movieapptask.dagger.component

import com.iti.mobile.movieapptask.MainActivity
import com.iti.mobile.movieapptask.dagger.modules.controller.ControllerModule
import com.iti.mobile.movieapptask.dagger.modules.controller.ViewModelModule
import com.iti.mobile.movieapptask.dagger.scopes.ActivityScope
import com.iti.mobile.movieapptask.features.moviesList.MoviesListFragment
import dagger.Subcomponent

@ActivityScope
@Subcomponent(modules = [ControllerModule::class, ViewModelModule::class])
interface ControllerComponent {
    fun inject(fragment: MoviesListFragment)
}