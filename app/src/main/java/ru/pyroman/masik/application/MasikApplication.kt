package ru.pyroman.masik.application

import android.app.Application
import ru.pyroman.masik.application.di.AppComponent
import ru.pyroman.masik.application.di.DaggerAppComponent

class MasikApplication : Application() {

    lateinit var appComponent: AppComponent
        private set

    override fun onCreate() {
        appComponent = DaggerAppComponent
            .factory()
            .create(
                application = this
            )
        super.onCreate()
    }
}