package com.core.data.repos

import com.core.data.base.BaseRepo
import com.core.data.controlers.UsersController
import com.core.data.model.login.MoviesResponse
import com.core.data.network.ApiFactory
import com.core.data.network.NetworkBoundFileResource
import com.core.data.network.model.ResponseState
import com.core.network.NetworkFactoryInterface
import com.core.preference.DataStores
import com.core.preference.PreferencesKeys
import com.core.preference.sharedPref.SharedPref
import com.core.utils.FileManager
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.flow.MutableStateFlow
import retrofit2.Response
import javax.inject.Inject

class ProfileRepo
@Inject
constructor(
    val apiFactory: ApiFactory,
    dataStore: DataStores,
    networkFactory: NetworkFactoryInterface,
    val fileManager: FileManager,
    val usersController: UsersController,
    pref: SharedPref
) : BaseRepo(dataStore, networkFactory, pref) {
    fun getUserByEmail(email: String) = usersController.getUserByEmail(email)

    fun getUserEmail() = pref?.getUserEmail()
}
