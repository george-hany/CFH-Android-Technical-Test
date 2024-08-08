package com.app.app.ui.main.profile

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.app.database.users.UserEntity
import com.core.base.BaseViewModel
import com.core.data.repos.ProfileRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel
@Inject
constructor(val repo: ProfileRepo) : BaseViewModel<ProfileRepo>(repo) {
    val userEntity = MutableLiveData<UserEntity>()

    init {
        getUser()
    }

    private fun getUser() {
        viewModelScope.launch(Dispatchers.IO){
            val email = repo.getUserEmail()
            userEntity.postValue(repo.getUserByEmail(email ?: ""))
        }
    }
}
