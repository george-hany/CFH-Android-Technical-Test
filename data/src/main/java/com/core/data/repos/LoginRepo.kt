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

class LoginRepo
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

    suspend fun saveDataInStore(data: String) {
        dataStore.saveValue(PreferencesKeys.data, data)
    }

    suspend fun getDataFromStore() = dataStore.getValue(PreferencesKeys.data, "")

    suspend fun getHomeDataFromStore() = dataStore.getValue(PreferencesKeys.homeData, "")
    fun saveEmailInSharedPref(email: String) {
        pref?.saveUserEmail(email)
    }
}
