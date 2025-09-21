package ru.pyroman.masik.activity.di

import dagger.Subcomponent
import ru.pyroman.masik.activity.MainActivity
import ru.pyroman.masik.feature.note.list.di.NoteListFeatureModule

@Subcomponent(modules = [
    NoteListFeatureModule::class,
])
@MainActivityScope
interface MainActivityComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): MainActivityComponent
    }

    fun inject(instance: MainActivity)
}