package com.iti.mobile.movieapptask.dagger.modules.app

import androidx.lifecycle.ViewModelProvider
import com.iti.mobile.movieapptask.features.base.ViewModelProviderFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelFactoryModule {
    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelProviderFactory): ViewModelProvider.Factory
}