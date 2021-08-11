package ezlink.project.screentest.Presenter

import android.util.Log
import ezlink.project.screentest.Api.ApiRetrofit
import ezlink.project.screentest.Presenter.Interface.GenreInterface
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class GenrePresenter(val genreInterface: GenreInterface) {

    fun genre(api_key : String){

        genreInterface.startProgress()

        ApiRetrofit.getRetrofit().genre(api_key)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                genreInterface.hideProgress()

                val dataGenre = it.genres
                if(dataGenre?.size ?: 0>0){
                    genreInterface.success(dataGenre)
                }else{
                    genreInterface.error("Data tidak tersedia")
                }
            },{
                genreInterface.error(it.localizedMessage)
            })
    }
}