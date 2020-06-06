package com.iti.mobile.movieapptask.dagger.modules.app

import android.app.Application
import com.iti.mobile.movieapptask.dagger.scopes.ApplicationScope
import com.iti.mobile.movieapptask.model.room.MoviesDao
import com.iti.mobile.movieapptask.model.room.MoviesDatabase
import com.iti.mobile.movieapptask.utils.DATABASE_NAME

import dagger.Module
import dagger.Provides

@Module(includes = [ApplicationModule::class])
class RoomModule {

    @ApplicationScope
    @Provides
    fun provideLocalDatabase (mApplication: Application) : MoviesDatabase{
        return androidx.room.Room
            .databaseBuilder(mApplication,MoviesDatabase::class.java, DATABASE_NAME)
            .fallbackToDestructiveMigration()
            .build()
    }

    @ApplicationScope
    @Provides
    fun provideMovieDao (localDatabase: MoviesDatabase) : MoviesDao{
        return  localDatabase.movieDao
    }
}