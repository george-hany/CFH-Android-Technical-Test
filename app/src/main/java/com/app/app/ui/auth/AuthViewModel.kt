package com.app.app.ui.auth

import com.core.base.BaseViewModel
import com.core.data.repos.AuthRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AuthViewModel
    @Inject
    constructor(
        repo: AuthRepo,
    ) : BaseViewModel<AuthRepo>(repo)
