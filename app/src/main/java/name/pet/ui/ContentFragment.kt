package name.pet.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import name.pet.R
import name.pet.data.repository.PetRepository

class ContentFragment : Fragment(R.layout.content) {

    private val repo = PetRepository.getInstance()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }
}