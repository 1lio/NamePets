package name.pet.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.content.*
import name.pet.R
import name.pet.data.repository.AppDatabase
import kotlin.random.Random

class ContentFragment : Fragment(R.layout.content) {

    private lateinit var db: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        db = AppDatabase.getInstance(context!!.applicationContext)
    }

    private fun getRandomName(type: Int, gender: Int): String {

        val dao = db.petDao()
        val list = dao.getCats()

        val random = Random.nextInt(0, list.size)

        val pet = list[random]
        return pet.name
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnPetName.setOnClickListener {
            val randomName = getRandomName(
                0,
                0
            )

            petName.text = randomName
        }

    }
}