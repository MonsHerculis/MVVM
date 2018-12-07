package skipcreative.com.MVVM.service.repository


import android.arch.lifecycle.MutableLiveData

import java.net.HttpURLConnection


import skipcreative.com.MVVM.service.model.User
import android.util.Log
import okhttp3.ResponseBody
import retrofit2.Response


class LedRepository {

    private val data = MutableLiveData<String>()

    val led: MutableLiveData<String>
        get() {

            val apiInterface = ApiClient.getRequestsRetrofit().create<ApiInterface>(ApiInterface::class.java!!)
            val call = apiInterface.led
            call.enqueue(object : AbstractCallback<ResponseBody>() {
                override fun onResultOK(response: Response<ResponseBody>) {
                    if (response.code() == HttpURLConnection.HTTP_OK || response.code() == HttpURLConnection.HTTP_CREATED) {
                        data.setValue(response.toString())
                    } else if (response.code() == HttpURLConnection.HTTP_UNAUTHORIZED) {

                    }
                }
                override fun onFail(msg: String) {
                    Log.d("errore", msg)

                }
            })
            return data
        }


}