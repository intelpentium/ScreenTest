package ezlink.project.screentest.Presenter

import ezlink.project.screentest.Api.ApiRetrofit
import ezlink.project.screentest.Presenter.Interface.MovieDetailInterface
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class MovieDetailPresenter (val moviedetailInterface: MovieDetailInterface) {

    fun genre(genreid: Int?, api_key : String?){

        moviedetailInterface.startProgress()

        ApiRetrofit.getRetrofit().moviedetail(genreid, api_key)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                moviedetailInterface.hideProgress()

                val dataMovie = it
                moviedetailInterface.success(dataMovie)
            },{
                moviedetailInterface.error(it.localizedMessage)
            })
    }
}