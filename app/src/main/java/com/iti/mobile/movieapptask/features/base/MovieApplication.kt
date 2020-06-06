package com.iti.mobile.movieapptask.features.base

import android.app.Application
import com.iti.mobile.movieapptask.BuildConfig
import com.iti.mobile.movieapptask.dagger.component.DaggerMoviesAppComponent
import com.iti.mobile.movieapptask.dagger.component.MoviesAppComponent
import com.iti.mobile.movieapptask.dagger.modules.app.ApplicationModule
import timber.log.Timber

class MovieApplication : Application(){
    lateinit var appComponent: MoviesAppComponent

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
        appComponent = DaggerMoviesAppComponent.builder()
            .applicationModule(ApplicationModule(this))
            .build()
        appComponent.inject(this)
    }
}