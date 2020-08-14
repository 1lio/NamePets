package name.pet.data.model

data class Pet(

    val id: String,
    val type: String = "cat",       // cat or dog
    val name: String = "Васька",
    val gender: Boolean = true      // true is male other female
)