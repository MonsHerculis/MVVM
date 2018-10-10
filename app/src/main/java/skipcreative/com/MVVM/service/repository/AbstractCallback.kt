package skipcreative.com.MVVM.service.repository

import java.net.HttpURLConnection

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

abstract class AbstractCallback<E> protected constructor() : Callback<E> {

    override fun onResponse(call: Call<E>, response: Response<E>) {
        when (response.code()) {
            HttpURLConnection.HTTP_OK, HttpURLConnection.HTTP_CREATED -> onResultOK(response)
            HttpURLConnection.HTTP_UNAUTHORIZED, HttpURLConnection.HTTP_FORBIDDEN -> onFail(response.raw().toString())
            else -> onFail(response.raw().toString())
        }
    }

    override fun onFailure(call: Call<E>, t: Throwable) {
        onFail(t.message!!)
    }

    protected abstract fun onResultOK(response: Response<E>)


    protected abstract fun onFail(msg: String)


}