package name.pet.data.repository

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import name.pet.data.model.Pet
import name.pet.data.model.PetDog

@Database(entities = [Pet::class, PetDog::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    companion object {

        private const val DB_NAME = "names"
        private const val DB_DIR = "databases/names.db"

        fun getInstance(context: Context): AppDatabase {
            return Room
                .databaseBuilder(context, AppDatabase::class.java, DB_NAME)
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .createFromAsset(DB_DIR)
                .build()
        }

    }

    abstract fun petDao(): PetDao
}