package ru.pyroman.masik.common

interface Reducer<State, Intent> {

    fun reducer(currentState: State, intent: Intent): State
}