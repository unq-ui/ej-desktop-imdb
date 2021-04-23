package org.view

import org.model.DraftMovie
import org.model.MovieSystem
import org.model.RepeatedException
import org.model.getMovieSystem
import org.uqbar.commons.model.annotations.Observable
import org.uqbar.commons.model.exceptions.UserException

@Observable
class MovieViewModel(var id: String, var title: String, var description: String)

@Observable
class ImdbModel(val imdbSystem: MovieSystem = getMovieSystem()){
    lateinit var movies: List<MovieViewModel>

    init { updateMovies() }

    private fun updateMovies() {
        movies = imdbSystem.movies.map{ MovieViewModel(it.id,it.title,it.description)}
    }

    var selected: MovieViewModel? = null
        set(value) {
            check = true
            field = value
        }
    var check = false

    fun editMovie(id: String, movie: DraftMovieModel) {
        imdbSystem.editMovie(id, DraftMovie(movie.title,movie.description))
        updateMovies()
    }

    fun addMovie(movie: DraftMovieModel) {
        try {imdbSystem.addMovie(DraftMovie(movie.title,movie.description))}
        catch (e: RepeatedException) {
            throw UserException(e.message)
        }
        updateMovies()
    }

    fun removeMovie(id: String) {
        imdbSystem.removeMovie(id)
        updateMovies()
    }


}
@Observable
class DraftMovieModel(var title: String, var description: String)