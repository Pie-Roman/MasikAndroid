package ru.pyroman.masik.data.note.list.network.mapper

import ru.pyroman.masik.data.note.common.network.mapper.NoteNetworkMapper
import ru.pyroman.masik.data.note.common.network.mapper.NoteTagNetworkMapper
import ru.pyroman.masik.data.note.list.network.dto.NoteListNetworkDto
import ru.pyroman.masik.domain.note.list.model.NoteList
import javax.inject.Inject

internal class NoteListNetworkMapper @Inject constructor(
    private val noteNetworkMapper: NoteNetworkMapper,
    private val noteTagNetworkMapper: NoteTagNetworkMapper,
) {

    fun map(dto: NoteListNetworkDto): NoteList {
        val items = dto.items.orEmpty().map { noteDto ->
            noteNetworkMapper.map(noteDto)
        }
        val tags = dto.tags.orEmpty().map { tagDto ->
            noteTagNetworkMapper.map(tagDto)
        }

        return NoteList(
            items = items,
            tags = tags,
        )
    }
}