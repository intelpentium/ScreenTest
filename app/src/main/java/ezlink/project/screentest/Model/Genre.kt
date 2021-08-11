package ezlink.project.screentest.Model

import com.google.gson.annotations.SerializedName

data class Genre(

	@field:SerializedName("genres")
	val genres: List<GenreItem?>? = null
)

data class GenreItem(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("id")
	val id: Int? = null
)
