package name.pet

import android.app.Application
import name.pet.data.repository.AppDatabase

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        AppDatabase.getInstance(this)
    }
}