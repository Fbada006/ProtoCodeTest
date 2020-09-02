package com.droidafricana.protocodetest.login

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.droidafricana.protocodetest.db.UserDb
import com.droidafricana.protocodetest.utils.Event

class LoginViewModel @ViewModelInject constructor(private val userDb: UserDb) : ViewModel() {

    private val _navigateToMainScreen = MutableLiveData<Event<Boolean>>()

    val navigateToMainScreen: LiveData<Event<Boolean>>
        get() = _navigateToMainScreen

    fun onLoginClicked(phone: String, password: String) {
        if (phone.isNotEmpty() && password.isNotEmpty()) {
            if (userDb.getString(phone) != "") {
                _navigateToMainScreen.value = Event(true)
            }
        }
    }

    fun onRegisterClicked() {
        TODO("Not yet implemented")
    }
}
