package ru.pyroman.masik.feature.note.list.state

import ru.pyroman.masik.domain.note.list.model.NoteList

sealed interface NoteListState {

    data object Idle : NoteListState

    data class Loading(
        val noteList: NoteList,
    ) : NoteListState

    data class Loaded(
        val noteList: NoteList,
    ) : NoteListState

    data class Error(
        val message: String,
    ) : NoteListState
}