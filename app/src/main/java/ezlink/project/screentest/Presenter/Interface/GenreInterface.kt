package ezlink.project.screentest.Presenter.Interface

import ezlink.project.screentest.Model.GenreItem

interface GenreInterface {
    fun success(genre: List<GenreItem?>?)
    fun error(msg: String)
    fun startProgress()
    fun hideProgress()
}