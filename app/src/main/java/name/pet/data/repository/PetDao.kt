package name.pet.data.repository

import androidx.room.Dao
import androidx.room.Query
import name.pet.data.model.Pet

@Dao
interface PetDao {

    @Query("SELECT * FROM cats WHERE gender = :gender")
    fun getCats(gender: Int = 1): List<Pet>

  /*  @Query("SELECT * FROM dogs WHERE gender = :gender")
    fun getDogs(gender: Int = 1): List<PetDog>*/

}