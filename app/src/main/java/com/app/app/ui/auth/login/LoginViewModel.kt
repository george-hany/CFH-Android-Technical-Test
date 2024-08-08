package com.app.app.ui.auth.login

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.app.app.ui.auth.login.model.LoginRequestUIModel
import com.app.database.users.UserEntity
import com.core.base.BaseViewModel
import com.core.utils.*
import com.core.data.repos.LoginRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel
@Inject
constructor(val repo: LoginRepo) : BaseViewModel<LoginRepo>(repo) {
    val loginRequestUIModel = LoginRequestUIModel()
    val userLoginSuccess = MutableLiveData<Boolean>()
    fun validate(v: View) {
        loginRequestUIModel.run {
            when {
                email.value.isInputEmpty() -> message.value = R.string.pleaseEnterEmail
                email.value.isEmailValid().not() -> message.value = R.string.pleaseEnterValidEmail
                password.value.isInputEmpty() -> message.value = R.string.pleaseEnterPassword
                else -> login(v)
            }
        }
    }

    private fun login(v: View) {
        viewModelScope.launch(Dispatchers.IO) {
            loginRequestUIModel.run {
                val user = repo.getUserByEmail(email.value ?: "")
                if (user == null || user.password != password.value)
                    message.postValue(R.string.wrong_email_or_password)
                else
                    saveUserEmail(user)
            }
        }
    }

    private fun saveUserEmail(user: UserEntity) {
        repo.saveEmailInSharedPref(user.email)
        userLoginSuccess.postValue(true)
    }
}
