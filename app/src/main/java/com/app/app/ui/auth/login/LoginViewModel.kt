package com.app.app.ui.auth.login

import android.view.View
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.core.base.BaseViewModel
import com.core.data.network.model.ResponseState
import com.core.data.repos.LoginRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class LoginViewModel
    @Inject
    constructor(val repo: LoginRepo) : BaseViewModel<LoginRepo>(repo) {
        val data = MutableLiveData<String>()
        var dataFromStore = MutableLiveData<String>()
        var homeData = MutableLiveData<String>()
        var loginMediatorLiveData = MediatorLiveData<Any>()

        init {
            viewModelScope.launch {
                repo.getDataFromStore().collect { value -> dataFromStore.value = value }
                repo.getHomeDataFromStore().collect { value -> homeData.value = value }
            }
            getMovies()
        }

        fun getMovies() {
            viewModelScope.launch {
                repo.requestHelpsList().collect {
                    isLoading.value = it is ResponseState.Loading
                    when (it) {
                        is ResponseState.Success -> Timber.tag("getMovies").e("${it.data}")
                        is ResponseState.Error -> message.value = it.message
                        is ResponseState.Loading -> isLoading.value = true
                    }
                }
            }
        }

        fun onSaveClick(v: View) {
            viewModelScope.launch {
                repo.saveDataInStore(data = data.value ?: "")
            }
        }
    }
