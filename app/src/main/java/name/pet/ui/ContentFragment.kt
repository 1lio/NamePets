package name.pet.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.content.*
import name.pet.R
import name.pet.data.model.Pet
import name.pet.data.repository.AppDatabase
import kotlin.random.Random

class ContentFragment : Fragment(R.layout.content) {

    private lateinit var db: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        db = AppDatabase.getInstance(context!!.applicationContext)
    }

    private fun getRandomName(animal: Int, gender: Int): String {
        val listPet = if (animal == 0) {
            val catsDao = db.catsDao()
            catsDao.getCats(gender)
        } else {
            val dogsDao = db.dogsDao()
            dogsDao.getDogs(gender)
        }

        val random = Random.nextInt(0, listPet.size)

        val pet = listPet[random]
        return pet.name
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnPetName.setOnClickListener {
            val randomName = getRandomName(
                if (cat.isChecked) 0
                else 1,
                if (male.isChecked) 1
                else 0
            )
            petName.text = randomName
        }

    }
}