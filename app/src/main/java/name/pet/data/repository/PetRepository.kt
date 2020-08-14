package name.pet.data.repository

import name.pet.data.model.Pet
import java.util.ArrayList

class PetRepository : PetDB {

    override fun getCats(gender: Boolean): ArrayList<Pet> {
        return arrayListOf()
    }

    override fun getDogs(gender: Boolean): ArrayList<Pet> {
        return arrayListOf()
    }

    override fun getRandomName(type: Boolean, gender: Boolean): String {
        return "Васька"
    }


    companion object {
        fun getInstance () = PetRepository()
    }

}