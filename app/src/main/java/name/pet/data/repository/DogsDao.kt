package name.pet.data.repository

import androidx.room.Dao
import androidx.room.Query
import name.pet.data.model.Dogs

@Dao
interface DogsDao {

    @Query("SELECT * FROM dogs WHERE  gender = :gender")
    fun getDogs(gender: Int): List<Dogs>
}