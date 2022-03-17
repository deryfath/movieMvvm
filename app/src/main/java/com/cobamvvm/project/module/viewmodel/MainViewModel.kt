package com.cobamvvm.project.module.viewmodel

import androidx.lifecycle.MutableLiveData
import com.cobamvvm.project.data.DataRepository
import com.cobamvvm.project.data.model.Movie
import com.cobamvvm.project.data.model.MovieResult
import kotlinx.coroutines.launch

class MainViewModel(private val repository: DataRepository):AbstractVIewModel() {

    val movieTopRated = MutableLiveData<List<MovieResult>>()
    val movieUpcoming = MutableLiveData<List<MovieResult>>()
    val moviePopular = MutableLiveData<MutableList<MovieResult>>()
    val movieNowPlaying = MutableLiveData<List<MovieResult>>()

    fun getMovieHome(curPage:Int){
        launch {
            try {
                setLoading()

//                val dataMovieTopRated = repository.getMovieTopRated()
//                val dataMovieUpcoming = repository.getMovieUpcoming()
                val dataMoviePopular = repository.getMoviePopular(curPage)
//                val dataMovieNowPlaying = repository.getMovieNowPlaying()

//                movieTopRated.postValue(dataMovieTopRated.results)
//                movieUpcoming.postValue(dataMovieUpcoming.results)
                moviePopular.postValue(dataMoviePopular.results)
//                movieNowPlaying.postValue(dataMovieNowPlaying.results)


            }catch (t:Throwable){
                println("ERROR COROUTINE "+t.message)

                setError(t)
            }finally {
                setLoading(false)
            }
        }
    }

    fun start(){
        movieTopRated.value = emptyList()
        movieUpcoming.value = emptyList()
        moviePopular.value = arrayListOf()
        movieNowPlaying.value = emptyList()
    }
}