package skipcreative.com.MVVM.viewmodel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData

import skipcreative.com.MVVM.service.model.User
import skipcreative.com.MVVM.service.repository.UserRepository

class UserViewModel(application: Application) : AndroidViewModel(application) {
    val userObservable: MutableLiveData<List<User>>

    init {
        userObservable = UserRepository().user
    }
}
