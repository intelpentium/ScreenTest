package ezlink.project.screentest.Presenter.Interface

import ezlink.project.screentest.Model.GenreItem
import ezlink.project.screentest.Model.MovieItem
import retrofit2.Response

interface MovieDetailInterface {
    fun success(response: MovieItem)
    fun error(msg: String)
    fun startProgress()
    fun hideProgress()
}