package com.iti.mobile.movieapptask.dagger.modules.app


import com.iti.mobile.movieapptask.dagger.scopes.ApplicationScope
import com.iti.mobile.movieapptask.model.network.MovieApi
import com.iti.mobile.movieapptask.utils.BASE_URL
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

@Module(includes = [NetworkModule::class])
class ApiServicesModule{

    @ApplicationScope
    @Provides
    fun getApiService(retrofit: Retrofit) = retrofit.create(MovieApi::class.java)

    @ApplicationScope
    @Provides
    fun getRetrofit(okHttpClient: OkHttpClient) =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
}