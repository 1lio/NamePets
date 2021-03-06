package name.pet.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cats")
data class Cats(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "_id")
    val id: Int,

    @ColumnInfo(name = "gender")
    val gender: Int = 1,      // 1 is male other female,

    @ColumnInfo(name = "name")
    override val name: String = "Васька"

) : Pet(name)