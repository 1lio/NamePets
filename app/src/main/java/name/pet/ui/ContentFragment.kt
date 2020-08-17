package name.pet.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.room.Room
import kotlinx.android.synthetic.main.content.*
import name.pet.R
import name.pet.data.repository.AppDatabase
import java.io.File

class ContentFragment : Fragment() {

    private lateinit var db: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        db = Room
            .databaseBuilder(requireContext().applicationContext, AppDatabase::class.java, "names")
            .createFromFile(File("raw/names.db"))
            .allowMainThreadQueries()
            .build()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, state: Bundle?): View? {
        super.onCreateView(inflater, container, state)
        return inflater.inflate(R.layout.content, container, false)
    }

    private fun getRandomName(type: Int, gender: Int): String {
        if (type == 1) db.petDao().getCats(gender) else db.petDao().getDogs(gender)
        return "Васька"
    }

    // private val repo = PetRepository(context!!)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnPetName.setOnClickListener {
            val randomName = getRandomName(
                radioAnimal.checkedRadioButtonId,
                radioGender.checkedRadioButtonId
            )

            petName.text = randomName
        }

    }
}