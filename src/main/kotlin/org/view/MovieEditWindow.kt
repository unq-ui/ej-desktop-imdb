package org.view

import org.uqbar.arena.kotlin.extensions.*
import org.uqbar.arena.widgets.*
import org.uqbar.arena.windows.Dialog
import org.uqbar.arena.windows.WindowOwner
import org.uqbar.commons.model.exceptions.UserException

class MovieEditWindow(owner: WindowOwner, model: DraftMovieModel, val windowTitle: String): Dialog<DraftMovieModel>(owner, model) {
    override fun createFormPanel(mainPanel: Panel) {
        title = windowTitle
        setMinWidth(400)
        Label(mainPanel) with {
            text = "Título"
        }
        TextBox(mainPanel) with {
            bindTo("title")
        }
        Label(mainPanel) with {
            text = "Descripción"
        }
        TextBox(mainPanel) with {
            bindTo("description")
        }
        Button(mainPanel) with {
            text = "Aceptar"
            onClick {
                if (modelObject.title.isEmpty()) {
                    throw UserException("El título no puede ser vacío")
                }
                else {
                    accept()
                }
            }
        }
        Button(mainPanel) with {
            text = "Cancelar"
            onClick {
                cancel()
            }
        }
    }
}