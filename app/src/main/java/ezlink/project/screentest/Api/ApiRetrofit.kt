package ezlink.project.screentest.Api

import ezlink.project.screentest.Helper.Config
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class ApiRetrofit {

    companion object{
        fun getRetrofit() : ApiService{
            val retrofit = Retrofit.Builder()
                .baseUrl(Config.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create()) // Reactive Programming
                .build()

            val service = retrofit.create(ApiService::class.java)

            return service
        }
    }
}