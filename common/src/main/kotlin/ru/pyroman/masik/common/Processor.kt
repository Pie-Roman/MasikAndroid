package ru.pyroman.masik.common

interface Processor<Intent> {

    fun process(intent: Intent)
}