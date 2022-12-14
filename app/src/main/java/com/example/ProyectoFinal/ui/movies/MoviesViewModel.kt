package com.example.ProyectoFinal.ui.movies
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ProyectoFinal.repository.TheMovieDBRepository
import com.example.ProyectoFinal.retrofit.response.Movie


class MoviesViewModel : ViewModel() {
    private var theMovieDBRepository: TheMovieDBRepository
    private var popularMovies: LiveData<List<Movie>>
    val selectedMovie: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }

    init {
        theMovieDBRepository = TheMovieDBRepository()
        popularMovies = theMovieDBRepository.popularMovies()!!
    }

    fun getPopularMovies(): LiveData<List<Movie>>? {
        if(selectedMovie == null) selectedMovie.setValue(popularMovies.value?.get(0)?.id)
        return popularMovies
    }

}