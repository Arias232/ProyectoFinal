package com.example.ProyectoFinal.retrofit

import com.example.ProyectoFinal.retrofit.response.MovieDetailResponse
import com.example.ProyectoFinal.retrofit.response.PopularMoviesResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface TheMovieDBService {

    @GET("movie/popular")
    fun getPopularMovies(): Call<PopularMoviesResponse>

    @GET("movie/{movie_id}")
    fun getMovieDetails(@Path("movie_id") movieId: Int): Call<MovieDetailResponse>

}