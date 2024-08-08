package com.app.app.ui.main

import com.core.base.BaseViewModel
import com.core.data.repos.MainRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel
    @Inject
    constructor(val mainRepo: MainRepo) :
    BaseViewModel<MainRepo>(mainRepo) {
    fun clearUserEmail() {
        mainRepo.saveUserEmail(null)
    }
}
