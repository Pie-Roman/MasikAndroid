package ru.pyroman.masik.data.note.common.network.dto

import com.google.gson.annotations.SerializedName

data class NoteNetworkDto(
    @SerializedName("id") val id: String?,
    @SerializedName("body") val body: NoteBodyNetworkDto?,
)