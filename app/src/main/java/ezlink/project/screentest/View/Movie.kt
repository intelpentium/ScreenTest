package ezlink.project.screentest.View

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import ezlink.project.screentest.Adapter.GenreAdapter
import ezlink.project.screentest.Adapter.MovieAdapter
import ezlink.project.screentest.Helper.Config
import ezlink.project.screentest.Model.MovieItem
import ezlink.project.screentest.Presenter.MoviePresenter
import ezlink.project.screentest.Presenter.Interface.MovieInterface
import ezlink.project.screentest.R
import kotlinx.android.synthetic.main.genre.*

class Movie : AppCompatActivity(), MovieInterface {

    lateinit var presenter: MoviePresenter

    var movieid: Int?=null
    var page: Int?=1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.genre)

        name.text = "Data List Movie"

        val bundle :Bundle ?=intent.extras
        if (bundle!=null){
            movieid = bundle.getInt("id") // 1
        }

        presenter = MoviePresenter(this)
        presenter.genre(movieid, page, Config.Api_Key)
    }

    override fun success(movie: List<MovieItem?>?) {
        recycler_view.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recycler_view.adapter = MovieAdapter(movie)
    }

    override fun error(msg: String) {
        Popup.PopupError(this, msg)
    }

    override fun startProgress() {
        shimmer_genre.visibility = View.VISIBLE
        recycler_view.visibility = View.GONE
    }

    override fun hideProgress() {
        shimmer_genre.visibility = View.GONE
        recycler_view.visibility = View.VISIBLE
    }
}