package ru.pyroman.masik.data.note.list.di

import dagger.Binds
import dagger.Module
import ru.pyroman.masik.data.note.list.network.di.NoteListNetworkDataModule
import ru.pyroman.masik.data.note.list.repository.NoteListRepositoryImpl
import ru.pyroman.masik.data.note.list.repository.NoteListTagsRepositoryImpl
import ru.pyroman.masik.domain.note.list.repository.NoteListRepository
import ru.pyroman.masik.domain.note.list.repository.NoteListTagsRepository

@Module(includes = [
    NoteListNetworkDataModule::class,
])
abstract class NoteListDataModule {

    @Binds
    internal abstract fun bindNoteListRepository(
        impl: NoteListRepositoryImpl,
    ): NoteListRepository

    @Binds
    internal abstract fun bindNoteListTagsRepository(
        impl: NoteListTagsRepositoryImpl,
    ): NoteListTagsRepository
}