package skipcreative.com.MVVM.service.repository


import okhttp3.ResponseBody
import skipcreative.com.MVVM.service.model.User
import retrofit2.Call
import retrofit2.http.GET


interface ApiInterface {
    @get:GET("/users")
    val user: Call<List<User>>


    @get:GET("/led/0")
    val led: Call<ResponseBody>
}