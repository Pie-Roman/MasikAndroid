package ru.pyroman.masik.data.note.list.network.dto

import com.google.gson.annotations.SerializedName
import ru.pyroman.masik.data.note.common.network.dto.NoteNetworkDto
import ru.pyroman.masik.data.note.common.network.dto.NoteTagNetworkDto

internal data class NoteListNetworkDto(
    @SerializedName("tags") val tags: List<NoteTagNetworkDto>?,
    @SerializedName("items") val items: List<NoteNetworkDto>?,
)