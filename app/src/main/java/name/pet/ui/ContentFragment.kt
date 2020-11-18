package name.pet.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.content.*
import name.pet.App
import name.pet.R
import name.pet.data.repository.AppDatabase
import kotlin.random.Random

class ContentFragment : Fragment(R.layout.content) {

    private lateinit var db: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        db = App.getDatabase()
    }

    private fun getRandomName(petType: Boolean, petGender: Boolean): String {
        val gender = if (petGender) 1 else 0
        val listPet = if (!petType) {
            db.catsDao().getCats(gender)
        } else {
            db.dogsDao().getDogs(gender)
        }

        val random = Random.nextInt(0, listPet.size)

        return listPet[random].name
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        randomName()
        btnPetName.setOnClickListener {
            randomName()
        }
    }

    private fun randomName() {
        petName.text = getRandomName(!cat.isChecked, male.isChecked)
    }

}


