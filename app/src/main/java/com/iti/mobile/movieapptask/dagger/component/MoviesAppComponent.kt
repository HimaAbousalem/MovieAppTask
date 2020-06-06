package com.iti.mobile.movieapptask.dagger.component

import com.iti.mobile.movieapptask.dagger.modules.app.ApiServicesModule
import com.iti.mobile.movieapptask.dagger.modules.app.RoomModule
import com.iti.mobile.movieapptask.dagger.modules.app.ViewModelFactoryModule
import com.iti.mobile.movieapptask.dagger.modules.controller.ControllerModule
import com.iti.mobile.movieapptask.dagger.scopes.ApplicationScope
import com.iti.mobile.movieapptask.features.base.MovieApplication
import dagger.Component

@ApplicationScope
@Component(modules = [ApiServicesModule::class, RoomModule::class, ViewModelFactoryModule::class])
interface MoviesAppComponent{
    fun controllerComponent(controllerModule: ControllerModule): ControllerComponent
    fun inject(app: MovieApplication)
}