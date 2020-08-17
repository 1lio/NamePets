package name.pet.data.repository

import android.content.Context
import androidx.room.Room
import java.io.File

class PetRepository(context: Context) {

    private val db = Room
        .databaseBuilder(context, AppDatabase::class.java, "pets")
        .createFromFile(File("raw/names.db"))
        .build()

    fun getRandomName(type: Int, gender: Int): String {

        if (type == 1) db.petDao().getCats(gender) else db.petDao().getDogs(gender)

        return "Васька"
    }

}
