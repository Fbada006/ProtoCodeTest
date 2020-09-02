package com.droidafricana.protocodetest.login

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.droidafricana.protocodetest.db.UserDb

class LoginViewModel @ViewModelInject constructor(private val userDb: UserDb) : ViewModel() {

    private val _navigateToMainScreen = MutableLiveData(false)
    private val _isRegisterSuccess = MutableLiveData(false)

    val navigateToMainScreen: LiveData<Boolean>
        get() = _navigateToMainScreen

    val isRegisterSuccess: LiveData<Boolean>
        get() = _isRegisterSuccess

    fun onLoginClicked(phone: String, password: String) {
        if (phone.isNotEmpty() && password.isNotEmpty()) {
            _navigateToMainScreen.value = userDb.getString(phone) != ""
        }
    }

    fun onRegisterClicked(
        phone: String,
        password: String,
        confirmPass: String,
        navigate: Boolean = false
    ) {
        if (navigate) {
            _isRegisterSuccess.value = true
        }
        if (phone.isNotEmpty() && password.isNotEmpty() && confirmPass.isNotEmpty()) {
            if (password == confirmPass) {
                try {
                    userDb.putString(phone, confirmPass)
                    _isRegisterSuccess.value = true
                } catch (ex: Exception) {
                    ex.printStackTrace()
                }
            }
        }
    }
}
