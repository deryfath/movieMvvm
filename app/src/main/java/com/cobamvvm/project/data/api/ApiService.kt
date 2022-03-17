package com.cobamvvm.project.data.api

import com.cobamvvm.project.data.model.MovieResponse
import retrofit2.http.GET
import kotlinx.coroutines.Deferred
import retrofit2.http.Query


interface ApiService {

    @GET("/3/movie/top_rated")
    fun getMovieTopRated():Deferred<MovieResponse>

    @GET("/3/movie/popular")
    fun getMoviePopular(@Query("page") page:Int):Deferred<MovieResponse>

    @GET("/3/movie/now_playing")
    fun getMovieNowPlaying():Deferred<MovieResponse>

    @GET("/3/movie/upcoming")
    fun getMovieUpcoming():Deferred<MovieResponse>


}