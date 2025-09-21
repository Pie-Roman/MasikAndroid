package ru.pyroman.masik.feature.note.list.viewmodel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import ru.pyroman.masik.domain.note.list.repository.NoteListTagsRepository
import javax.inject.Inject

@HiltViewModel
class NoteListTabsViewModel @Inject constructor(
    repository: NoteListTagsRepository,
) : ViewModel() {

    val tags = repository.getTags()
}