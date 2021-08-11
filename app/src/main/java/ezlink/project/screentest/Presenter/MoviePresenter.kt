package ezlink.project.screentest.Presenter

import ezlink.project.screentest.Api.ApiRetrofit
import ezlink.project.screentest.Presenter.Interface.MovieInterface
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class MoviePresenter (val movieInterface: MovieInterface) {

    fun genre(genreid: Int?, page: Int?, api_key : String?){

        movieInterface.startProgress()

        ApiRetrofit.getRetrofit().movie(genreid, page, api_key)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                movieInterface.hideProgress()

                val dataMovie = it.results
                if(dataMovie?.size ?: 0>0){
                    movieInterface.success(dataMovie)
                }else{
                    movieInterface.error("Data tidak tersedia")
                }
            },{
                movieInterface.error(it.localizedMessage)
            })
    }
}