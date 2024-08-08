package com.app.app.ui.auth

import com.core.base.BaseViewModel
import com.core.data.repos.AuthRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AuthViewModel
@Inject
constructor(
    val repo: AuthRepo,
) : BaseViewModel<AuthRepo>(repo) {
    private fun getEmail() = repo.getEmailFromSharedPref()

    fun isUserLoggedIn() = getEmail() != null
}
