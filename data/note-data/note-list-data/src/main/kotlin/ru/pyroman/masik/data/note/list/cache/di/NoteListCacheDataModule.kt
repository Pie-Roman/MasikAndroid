package ru.pyroman.masik.data.note.list.cache.di

import dagger.Module
import dagger.Provides
import ru.pyroman.masik.data.note.list.cache.repository.NoteListTagsCacheRepository

@Module
interface NoteListCacheDataModule {

    companion object {

        @Provides
        internal fun provideNoteListTagsCacheRepository(): NoteListTagsCacheRepository {
            return NoteListTagsCacheRepository()
        }
    }
}