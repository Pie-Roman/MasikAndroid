package ru.pyroman.masik.data.note.list.network.api

import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query
import ru.pyroman.masik.data.common.network.api.RetrofitBuilder
import ru.pyroman.masik.data.note.list.network.dto.NoteListLaunchNetworkDto
import ru.pyroman.masik.data.note.list.network.dto.NoteListNetworkDto

internal interface NoteListNetworkApi {

    @POST("/notes/launch")
    suspend fun launch(
        @Body data: NoteListLaunchNetworkDto,
    )

    @GET("/notes")
    suspend fun getNotes(
        @Query("tagId") tagId: String?,
    ): NoteListNetworkDto

    companion object {

        fun build(): NoteListNetworkApi = RetrofitBuilder()
            .build()
            .create(NoteListNetworkApi::class.java)
    }
}