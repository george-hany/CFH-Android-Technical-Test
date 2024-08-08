package com.app.app.ui.auth.register

import com.core.base.BaseViewModel
import com.core.data.repos.RegisterRepo
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.app.app.ui.auth.register.model.RegisterRequestUIModel
import com.core.utils.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject
constructor(val repo: RegisterRepo) : BaseViewModel<RegisterRepo>(repo) {
    val registerRequestUIModel = RegisterRequestUIModel()
    val userRegisterSuccess = MutableLiveData<Boolean>()

    fun validate(v: View) {
        registerRequestUIModel.run {
            when {
                firstName.value.isInputEmpty() -> message.value = R.string.pleaseEnterFirstName
                lastName.value.isInputEmpty() -> message.value = R.string.pleaseEnterLastName
                age.value.isInputEmpty() -> message.value = R.string.pleaseEnterYourAge
                age.value.isAgeValid().not() -> message.value = R.string.ageMustBeOnOrAbove18
                email.value.isInputEmpty() -> message.value = R.string.pleaseEnterEmail
                email.value.isEmailValid().not() -> message.value = R.string.pleaseEnterValidEmail
                password.value.isInputEmpty() -> message.value = R.string.pleaseEnterPassword
                password.value.isPasswordValid().not() -> message.value =
                    R.string.passwordShouldBe8CharactersLong

                passwordConfirmation.value.isInputEmpty() -> message.value =
                    R.string.pleaseEnterPasswordConfirmation

                password.value != passwordConfirmation.value -> message.value =
                    R.string.passwordNotMatchesConfirmPassword

                else -> register(v)
            }
        }
    }
    val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        // Handle the exception here (e.g., log it, show an error message, etc.)
        message.value = R.string.email_is_already_exists
        Timber.e("Exception caught: $throwable")
    }
    private fun register(v: View) {
        viewModelScope.launch(exceptionHandler) {
            registerRequestUIModel.run {
                repo.saveUser(
                    firstName.value ?: "",
                    lastName.value ?: "",
                    age.value?.toIntOrNull() ?: 0,
                    email.value ?: "",
                    password.value ?: ""
                )
                userRegisterSuccess.postValue(true)
            }
        }
    }

}