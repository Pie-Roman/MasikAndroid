package ru.pyroman.masik.data.note.list.network.dto

import com.google.gson.annotations.SerializedName
import ru.pyroman.masik.data.note.common.network.dto.NoteNetworkDto

internal data class NoteListLaunchNetworkDto(
    @SerializedName("systemNotes") val systemNotes: List<NoteNetworkDto>?,
)