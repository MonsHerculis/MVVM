package skipcreative.com.MVVM.service.repository


import skipcreative.com.MVVM.service.model.User
import retrofit2.Call
import retrofit2.http.GET


interface ApiInterface {
    @get:GET("/users")
    val user: Call<List<User>>
}