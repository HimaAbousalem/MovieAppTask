package com.iti.mobile.movieapptask.dagger.modules.controller

import androidx.appcompat.app.AppCompatActivity
import com.iti.mobile.movieapptask.dagger.qualifiers.ActivityContext
import com.iti.mobile.movieapptask.dagger.scopes.ActivityScope
import dagger.Module
import dagger.Provides

@Module
class ControllerModule(private val mActivity: AppCompatActivity){
    @ActivityContext
    @ActivityScope
    @Provides
    fun provideContext() = mActivity
}
