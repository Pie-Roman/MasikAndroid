package ru.pyroman.masik.domain.note.list.di

import dagger.Binds
import dagger.Module
import ru.pyroman.masik.common.Processor
import ru.pyroman.masik.domain.note.list.intent.NoteListIntent
import ru.pyroman.masik.domain.note.list.processor.NoteListProcessor

@Module
abstract class NoteListDomainModule {

    @Binds
    internal abstract fun bindNoteListProcessor(
        impl: NoteListProcessor,
    ): Processor<NoteListIntent>
}