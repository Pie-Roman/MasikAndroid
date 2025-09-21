package ru.pyroman.masik.data.note.list.network.datasource

import ru.pyroman.masik.data.note.list.network.api.NoteListNetworkApi
import ru.pyroman.masik.data.note.list.network.dto.NoteListLaunchNetworkDto
import ru.pyroman.masik.data.note.list.network.dto.NoteListNetworkDto

internal class NoteListNetworkDataSource(
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