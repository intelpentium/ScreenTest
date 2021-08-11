package ezlink.project.screentest.View

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import ezlink.project.screentest.Adapter.GenreAdapter
import ezlink.project.screentest.Helper.Config
import ezlink.project.screentest.Model.GenreItem
import ezlink.project.screentest.Presenter.GenrePresenter
import ezlink.project.screentest.Presenter.Interface.GenreInterface
import ezlink.project.screentest.R
import kotlinx.android.synthetic.main.genre.*

class Genre : AppCompatActivity(), GenreInterface {

    lateinit var presenter: GenrePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.genre)

        presenter = GenrePresenter(this)
        presenter.genre(Config.Api_Key)
    }

    override fun success(genre: List<GenreItem?>?) {
        recycler_view.layoutManager =LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recycler_view.adapter = GenreAdapter(genre)
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