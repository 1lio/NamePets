package name.pet.data.repository

import android.content.Context
import androidx.room.Room

class PetRepository(context: Context) {

    private val db = Room
        .databaseBuilder(context, AppDatabase::class.java, "pets")
        .build()


    fun getRandomName(type: Boolean, gender: Int): String {

        if (type) db.petDao().getCats(gender) else db.petDao().getDogs(gender)

        return "Васька"
    }

}
