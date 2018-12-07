package skipcreative.com.MVVM.viewmodel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import okhttp3.ResponseBody

import skipcreative.com.MVVM.service.model.User
import skipcreative.com.MVVM.service.repository.LedRepository
import skipcreative.com.MVVM.service.repository.UserRepository

class LedViewModel(application: Application) : AndroidViewModel(application) {
    val ledObservable: MutableLiveData<String>

    init {
        ledObservable = LedRepository().led
    }
}
