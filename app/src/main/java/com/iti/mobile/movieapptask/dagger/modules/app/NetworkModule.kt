package com.iti.mobile.movieapptask.dagger.modules.app

import android.app.Application
import android.content.Context
import com.iti.mobile.movieapptask.dagger.qualifiers.ApplicationContext
import com.iti.mobile.movieapptask.dagger.scopes.ApplicationScope
import com.iti.mobile.movieapptask.utils.HTTP_CACHE_DIR
import com.iti.mobile.movieapptask.utils.HTTP_CACHE_SIZE
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import timber.log.Timber
import java.io.File

@Module(includes = [ApplicationModule::class])
class NetworkModule{

    @ApplicationScope
    @Provides
    fun getOkHttpClient(loggingInterceptor: HttpLoggingInterceptor, cache: Cache) =
        OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .cache(cache)
            .build()

    @ApplicationScope
    @Provides
    fun cache(context: Application) = Cache(File(context.cacheDir, HTTP_CACHE_DIR), HTTP_CACHE_SIZE.toLong())

    @ApplicationScope
    @Provides
    fun httpLoggingInterceptor(): HttpLoggingInterceptor {
        val logging = HttpLoggingInterceptor { message -> Timber.d(message) }
        return logging.setLevel(HttpLoggingInterceptor.Level.BASIC)
    }


}