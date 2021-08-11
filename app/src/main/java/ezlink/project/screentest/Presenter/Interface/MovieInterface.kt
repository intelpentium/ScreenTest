package ezlink.project.screentest.Presenter.Interface

import ezlink.project.screentest.Model.MovieItem

interface MovieInterface {
    fun success(movie: List<MovieItem?>?)
    fun error(msg: String)
    fun startProgress()
    fun hideProgress()
}