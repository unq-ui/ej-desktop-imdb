package org.view

import org.uqbar.arena.Application
import org.uqbar.arena.windows.Window


class ImdbApplication: Application(){
    override fun createMainWindow(): Window<*> {
        return ImdbWindow(this, ImdbModel())
    }
}

fun main() {
    ImdbApplication().start()
}