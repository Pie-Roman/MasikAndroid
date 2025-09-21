package ru.pyroman.masik.data.note.common.network.dto

import com.google.gson.annotations.SerializedName

data class NoteTagNetworkDto(
    @SerializedName("id") val id: String?,
    @SerializedName("name") val name: String?,
    @SerializedName("color") val color: String?,
)