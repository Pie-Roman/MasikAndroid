package ru.pyroman.masik.data.note.common.network.mapper

import ru.pyroman.masik.data.note.common.network.dto.NoteBodyNetworkDto
import ru.pyroman.masik.domain.note.common.model.NoteBody
import javax.inject.Inject

class NoteBodyNetworkMapper @Inject constructor(
    private val noteTagNetworkMapper: NoteTagNetworkMapper,
) {

    fun map(dto: NoteBodyNetworkDto): NoteBody {
        val title = dto.title.orEmpty()
        val isDone = dto.isDone ?: false
        val tags = dto.tags.orEmpty().map { tagDto ->
            noteTagNetworkMapper.map(tagDto)
        }

        return NoteBody(
            title = title,
            isDone = isDone,
            tags = tags,
        )
    }
}