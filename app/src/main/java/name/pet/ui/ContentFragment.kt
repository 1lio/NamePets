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

    private fun getRandomName(petType: Int, petGender: Int): String {

        val listPet = if (petType == 0) {
            db.catsDao().getCats(petGender)
        } else {
            db.dogsDao().getDogs(petGender)
        }

        val random = Random.nextInt(0, listPet.size)

        return listPet[random].name
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnPetName.setOnClickListener {
            val randomName = getRandomName(
                if (cat.isChecked) 0 else 1,
                if (male.isChecked) 1 else 0
            )
            petName.text = randomName
        }

    }
}
