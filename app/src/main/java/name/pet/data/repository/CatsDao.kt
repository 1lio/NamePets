package name.pet.data.repository

import androidx.room.Dao
import androidx.room.Query
import name.pet.data.model.Cats

@Dao
interface CatsDao {

    @Query("SELECT * FROM cats WHERE gender = :gender")
    fun getCats(gender: Int): List<Cats>
}