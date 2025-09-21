package ru.pyroman.masik.data.note.common.network.dto

import com.google.gson.annotations.SerializedName

data class NoteBodyNetworkDto(
    @SerializedName("title") val title: String?,
    @SerializedName("isDone") val isDone: Boolean?,
    @SerializedName("tags") val tags: List<NoteTagNetworkDto>?,
)