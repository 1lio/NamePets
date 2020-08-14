package name.pet.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Pet(

    @PrimaryKey
    val id: String,

    @ColumnInfo(name = "name")
    val name: String = "Васька",

    @ColumnInfo(name = "gender")
    val gender: Boolean = true      // true is male other female
)