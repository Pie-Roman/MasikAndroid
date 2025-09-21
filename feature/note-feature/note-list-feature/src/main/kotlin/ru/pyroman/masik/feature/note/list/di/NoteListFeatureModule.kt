package ru.pyroman.masik.feature.note.list.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.migration.DisableInstallInCheck
import ru.pyroman.masik.common.Reducer
import ru.pyroman.masik.data.note.list.di.NoteListDataModule
import ru.pyroman.masik.domain.note.list.di.NoteListDomainModule
import ru.pyroman.masik.domain.note.list.intent.NoteListIntent
import ru.pyroman.masik.feature.note.list.reducer.NoteListReducer
import ru.pyroman.masik.feature.note.list.state.NoteListState

@Module(includes = [
    NoteListDataModule::class,
    NoteListDomainModule::class,
])
@InstallIn(ViewModelComponent::class)
abstract class NoteListFeatureModule {

    @Binds
    internal abstract fun bindNoteListReducer(
        impl: NoteListReducer,
    ): Reducer<NoteListState, NoteListIntent>
}