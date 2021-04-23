package org.view

import org.uqbar.arena.kotlin.extensions.*
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.widgets.*
import org.uqbar.arena.windows.Dialog
import org.uqbar.arena.windows.WindowOwner

class DeleteWindow(owner: WindowOwner, model: MovieViewModel): Dialog<MovieViewModel>(owner,model) {
    override fun createFormPanel(mainPanel: Panel) {
        Label(mainPanel) with {
            text = "¿Esta seguro que desea eliminar la pelicula con titulo: ${modelObject.title}?"
        }
        Button(mainPanel) with {
            text = "Aceptar"
            onClick {
                accept()
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