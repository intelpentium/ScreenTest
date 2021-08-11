package ezlink.project.screentest.View

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import ezlink.project.screentest.Helper.Config
import ezlink.project.screentest.Model.MovieItem
import ezlink.project.screentest.Presenter.Interface.MovieDetailInterface
import ezlink.project.screentest.Presenter.MovieDetailPresenter
import ezlink.project.screentest.R
import kotlinx.android.synthetic.main.movie_detail.*
import kotlinx.android.synthetic.main.progress.*

class MovieDetail: AppCompatActivity(), MovieDetailInterface {

    lateinit var presenter: MovieDetailPresenter

    var movieid: Int?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.movie_detail)

        val bundle : Bundle?=intent.extras
        if (bundle!=null){
            movieid = bundle.getInt("id") // 1
        }

        presenter = MovieDetailPresenter(this)
        presenter.genre(movieid, Config.Api_Key)
    }

    override fun success(response: MovieItem) {

        Glide.with(this).load(Config.URL_IMAGE+""+response.posterPath).into(poster_path)

        judul.text = response.title
        release_date.text = "Release Date : "+response.releaseDate
        vote_count.text = "Total Reviews : "+response.voteCount.toString()
        vote_average.text = response.voteAverage.toString()+" / 10.0"
        overview.text = response.overview.toString()
    }

    override fun error(msg: String) {
        Popup.PopupError(this, msg)
    }

    override fun startProgress() {
        progress.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        progress.visibility = View.GONE
    }
}