package name.pet.data.repository

import androidx.room.Database
import androidx.room.RoomDatabase
import name.pet.data.model.Pet

@Database(entities = [Pet::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun petDao(): PetDao
}