package skipcreative.com.MVVM.service.repository

import java.util.concurrent.TimeUnit

import skipcreative.it.MVVM.BuildConfig
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {


    var okHttpClient: OkHttpClient? = null
    private var ledRetrofit: Retrofit? = null
    private var requestsRetrofit: Retrofit? = null


    fun getLedRetrofit(): Retrofit {

        if (ledRetrofit == null) {
            okHttpClient = OkHttpClient.Builder()
                    .connectTimeout(30, TimeUnit.SECONDS)
                    .writeTimeout(30, TimeUnit.SECONDS)
                    .readTimeout(30, TimeUnit.SECONDS)
                    .build()

            ledRetrofit = Retrofit.Builder()
                    .baseUrl(BuildConfig.API_LED_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(okHttpClient!!)
                    .build()
        }
        return ledRetrofit!!

    }

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
