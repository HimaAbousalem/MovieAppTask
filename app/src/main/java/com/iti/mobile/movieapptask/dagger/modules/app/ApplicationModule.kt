package com.iti.mobile.movieapptask.dagger.modules.app

import android.app.Application
import android.content.Context
import com.iti.mobile.movieapptask.dagger.qualifiers.ApplicationContext
import com.iti.mobile.movieapptask.dagger.scopes.ApplicationScope

import dagger.Module
import dagger.Provides

@Module
class ApplicationModule (private var mApplication: Application) {

    @ApplicationScope
    @Provides
    fun provideApplication(): Application = mApplication
}