package com.cobamvvm.project.data

import com.cobamvvm.project.data.api.ApiService
import com.cobamvvm.project.data.local.DataBase
import com.cobamvvm.project.data.model.MovieResponse

class DataRepository(private val apiDataRepository: ApiService,
                     private val localDataSource: DataBase) {


    suspend fun getMovieTopRated(): MovieResponse {
        return apiDataRepository.getMovieTopRated().await()
    }

    suspend fun getMoviePopular(curPage:Int): MovieResponse {
        return apiDataRepository.getMoviePopular(curPage).await()
    }

    suspend fun getMovieUpcoming():MovieResponse{
        return apiDataRepository.getMovieUpcoming().await()
    }

    suspend fun getMovieNowPlaying():MovieResponse{
        return apiDataRepository.getMovieNowPlaying().await()
    }

}