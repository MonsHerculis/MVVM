package skipcreative.com.MVVM.service.repository


import android.arch.lifecycle.MutableLiveData

import java.net.HttpURLConnection


import skipcreative.com.MVVM.service.model.User
import android.util.Log
import retrofit2.Response


class UserRepository {

    private val data = MutableLiveData<List<User>>()

    val user: MutableLiveData<List<User>>
        get() {

            val apiInterface = ApiClient.getRequestsRetrofit().create<ApiInterface>(ApiInterface::class.java!!)
            val call = apiInterface.user
            call.enqueue(object : AbstractCallback<List<User>>() {
                override fun onResultOK(response: Response<List<User>>) {
                    if (response.code() == HttpURLConnection.HTTP_OK || response.code() == HttpURLConnection.HTTP_CREATED) {
                        data.setValue(response.body())
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