package ru.pyroman.masik.common

interface Reducer<State, Intent> {

    fun reduce(currentState: State, intent: Intent): State
}