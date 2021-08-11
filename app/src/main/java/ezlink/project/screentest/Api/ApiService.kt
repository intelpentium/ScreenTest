package ezlink.project.screentest.Api

import ezlink.project.screentest.Model.Genre
import ezlink.project.screentest.Model.Movie
import ezlink.project.screentest.Model.MovieItem
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    // list genre
    @GET("genre/movie/list")
    fun genre(@Query("api_key") apikey: String): Flowable<Genre>

    // list movie
    @GET("discover/movie")
    fun movie(@Query("with_genres") movieid: Int?,
              @Query("page") page: Int?,
              @Query("api_key") apikey: String?): Flowable<Movie>

    // movie detail
    @GET("movie/{id}")
    fun moviedetail(@Path("id") movieid: Int?,
                    @Query("api_key") apikey: String?): Single<MovieItem>
//
//    // movie detail
//    @GET("movie/{id}/reviews")
//    fun review(@Path("id") movieid: Int?,
//               @Query("page") page: Int?,
//               @Query("api_key") apikey: String): Call<Review>
//
//    // youtube detail
//    @GET("movie/{id}/videos")
//    fun youtube(@Path("id") movieid: Int?,
//                    @Query("api_key") apikey: String): Call<Youtube>
}