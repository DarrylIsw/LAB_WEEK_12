package com.example.test_lab_week_12

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.test_lab_week_12.MovieService
import com.example.test_lab_week_12.model.Movie
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class MovieRepository(private val movieService: MovieService) {

    private val apiKey = "c9d68f049152675117bb17e94644610d"

    fun fetchMovies(): Flow<List<Movie>> {
        return flow {
            val popularMovies = movieService.getPopularMovies(apiKey).results

            // Sort descending by popularity
            val sortedMovies = popularMovies.sortedByDescending { it.popularity }

            // Emit the sorted list
            emit(sortedMovies)
        }.flowOn(Dispatchers.IO)
    }

}
