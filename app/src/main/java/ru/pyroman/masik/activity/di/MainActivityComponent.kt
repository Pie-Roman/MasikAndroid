package ru.pyroman.masik.activity.di

import dagger.Subcomponent
import ru.pyroman.masik.activity.MainActivity

@Subcomponent(modules = [

])
@MainActivityScope
interface MainActivityComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): MainActivityComponent
    }

    fun inject(instance: MainActivity)
}