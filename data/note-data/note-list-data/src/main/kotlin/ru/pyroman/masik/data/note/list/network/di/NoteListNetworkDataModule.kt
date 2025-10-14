package ru.pyroman.masik.data.note.list.network.di

import dagger.Module
import dagger.Provides
import ru.pyroman.masik.data.note.list.network.api.NoteListNetworkApi
import ru.pyroman.masik.data.note.list.network.datasource.NoteListNetworkDataSource
import ru.pyroman.masik.data.note.list.network.mapper.NoteListNetworkMapper
import ru.pyroman.masik.data.note.list.network.repository.NoteListNetworkRepository

@Module
interface NoteListNetworkDataModule {

    companion object {

        @Provides
        internal fun provideNoteListNetworkApi(): NoteListNetworkApi {
            return NoteListNetworkApi.build()
        }
    }
}