package ru.pyroman.masik.data.note.list.network.datasource

import ru.pyroman.masik.data.note.list.network.api.NoteListNetworkApi
import ru.pyroman.masik.data.note.list.network.dto.NoteListLaunchNetworkDto
import ru.pyroman.masik.data.note.list.network.dto.NoteListNetworkDto
import javax.inject.Inject

internal class NoteListNetworkDataSource @Inject constructor(
    private val api: NoteListNetworkApi,
) {

    suspend fun launch(data: NoteListLaunchNetworkDto) {
        return api.launch(
            data = data,
        )
    }

    suspend fun getNotes(tagId: String?): NoteListNetworkDto {
        return api.getNotes(
            tagId = tagId,
        )
    }
}