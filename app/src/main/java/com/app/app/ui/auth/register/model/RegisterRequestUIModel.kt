package com.app.app.ui.auth.register.model

import androidx.lifecycle.MutableLiveData

class RegisterRequestUIModel {
    val firstName = MutableLiveData<String>()
    val lastName = MutableLiveData<String>()
    val age = MutableLiveData<String>()
    val email = MutableLiveData<String>()
    val password = MutableLiveData<String>()
    val passwordConfirmation = MutableLiveData<String>()
}