package org.view

import org.uqbar.arena.kotlin.extensions.*
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.windows.SimpleWindow
import org.uqbar.arena.windows.WindowOwner


class ImdbWindow(owner: WindowOwner, model: ImdbModel) : SimpleWindow<ImdbModel>(owner,model){
    override fun addActions(p0: Panel) {
        Button(p0) with {
            text = "Agregar"
            onClick {
                val movie = DraftMovieModel("", "")
                val view = MovieEditWindow(this@ImdbWindow, movie, "Agregar")
                view.onAccept {
                    modelObject.addMovie(movie)
                }
                view.open()
            }
        }
        Button(p0) with {
            text = "Editar"
            bindEnabledTo("check")
            onClick {
                val movie = DraftMovieModel(modelObject.selected!!.title, modelObject.selected!!.description)
                val view = MovieEditWindow(this@ImdbWindow, movie, "Editar")
                view.onAccept {
                    modelObject.editMovie(modelObject.selected!!.id, movie)
                }
                view.open()
            }
        }
        Button(p0) with {
            text = "Borrar"
            bindEnabledTo("check")
            onClick {
                val view = DeleteWindow(this@ImdbWindow, modelObject.selected!!)
                view.onAccept {
                    modelObject.removeMovie(modelObject.selected!!.id)
                }
                view.open()
            }
        }
    }

    override fun createFormPanel(p0: Panel) {
        title = "IMDB"
        setMinWidth(600)

        table<MovieViewModel>(p0) {
            bindItemsTo("movies")
            bindSelectionTo("selected")
            visibleRows = 10
            column {
                title = "ID"
                fixedSize = 30
                bindContentsTo("id")
            }
            column {
                title = "Title"
                weight = 50
                bindContentsTo("title")
            }
            column {
                title = "Description"
                bindContentsTo("description")
            }
        }

    }

}