package name.pet.data.repository

import androidx.room.Dao
import androidx.room.Query
import name.pet.data.model.Pet

@Dao
interface PetDao {

    @Query("SELECT cat FROM gender WHERE :gender")
    fun getCats(gender: Int = 1): List<Pet>

    @Query("SELECT dog FROM gender WHERE :gender")
    fun getDogs(gender: Int = 1): List<Pet>

}