package skipcreative.com.MVVM.service.repository

import java.util.concurrent.TimeUnit

import skipcreative.it.MVVM.BuildConfig
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {


    var okHttpClient: OkHttpClient? = null
    //private var loginRetrofit: Retrofit? = null
    private var requestsRetrofit: Retrofit? = null


   /* fun getLoginRetrofit(): Retrofit {

        if (loginRetrofit == null) {
            okHttpClient = OkHttpClient.Builder()
                    .connectTimeout(30, TimeUnit.SECONDS)
                    .writeTimeout(30, TimeUnit.SECONDS)
                    .readTimeout(30, TimeUnit.SECONDS)
                    .build()

            loginRetrofit = Retrofit.Builder()
                    .baseUrl(BuildConfig.API_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(okHttpClient!!)
                    .build()
        }
        return loginRetrofit!!

    }*/

    fun getRequestsRetrofit(): Retrofit {


        if (requestsRetrofit == null) {
            okHttpClient = OkHttpClient.Builder()
                    .connectTimeout(30, TimeUnit.SECONDS)
                    .writeTimeout(30, TimeUnit.SECONDS)
                    .readTimeout(30, TimeUnit.SECONDS)
                    .build()

            requestsRetrofit = Retrofit.Builder()
                    .baseUrl(BuildConfig.API_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(okHttpClient!!)
                    .build()
        }
        return requestsRetrofit!!

    }

}
