package name.pet.data.repository

import name.pet.data.model.Pet
import java.util.ArrayList

interface PetDB {

    fun getCats(gender: Boolean = true): ArrayList<Pet>

    fun getDogs(gender: Boolean = true): ArrayList<Pet>

    fun getRandomName(type: Boolean = true, gender: Boolean = true): String

}