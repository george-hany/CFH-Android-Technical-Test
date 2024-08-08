package com.app.app.ui.auth.login.model

import androidx.lifecycle.MutableLiveData

class LoginRequestUIModel {
    val email = MutableLiveData<String>()
    val password = MutableLiveData<String>()
}