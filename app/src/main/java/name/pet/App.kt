package name.pet

import android.app.Application
import name.pet.data.repository.AppDatabase

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this
        database = AppDatabase.getInstance(this)
    }

    companion object {

        private var instance: App? = null

        private var database: AppDatabase? = null

        fun getDatabase(): AppDatabase {
            if (database == null) database = AppDatabase.getInstance(instance!!)

            return database!!
        }
    }
}
