package ru.pyroman.masik.common

interface Handler<Intent> {

    fun handler(intent: Intent)
}