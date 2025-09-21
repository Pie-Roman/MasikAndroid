package ru.pyroman.masik.feature.note.list.reducer

import ru.pyroman.masik.common.Reducer
import ru.pyroman.masik.domain.note.list.intent.NoteListIntent
import ru.pyroman.masik.domain.note.list.model.NoteList
import ru.pyroman.masik.feature.note.list.state.NoteListState
import javax.inject.Inject

internal class NoteListReducer @Inject constructor(): Reducer<NoteListState, NoteListIntent> {

    override fun reduce(currentState: NoteListState, intent: NoteListIntent): NoteListState {
        return when (intent) {
            is NoteListIntent.ShowLoading -> {
                if (currentState is NoteListState.Loaded) {
                    NoteListState.Loading(
                        noteList = currentState.noteList,
                    )
                } else {
                    NoteListState.Loading(
                        noteList = NoteList(tags = emptyList(), items = emptyList())
                    )
                }
            }

            is NoteListIntent.ShowLoaded -> {
                NoteListState.Loaded(
                    noteList = intent.noteList,
                )
            }

            is NoteListIntent.ShowError -> {
                NoteListState.Error(
                    message = intent.error,
                )
            }

            else -> {
                currentState
            }
        }
    }
}