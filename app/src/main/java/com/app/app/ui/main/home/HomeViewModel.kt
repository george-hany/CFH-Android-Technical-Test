package com.app.app.ui.main.home

import com.core.base.BaseViewModel
import com.core.data.repos.HomeRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel
    @Inject
    constructor(repo: HomeRepo) : BaseViewModel<HomeRepo>(repo)
