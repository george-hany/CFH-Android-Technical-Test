package com.core.data.repos

import com.core.data.base.BaseRepo
import com.core.data.controlers.UsersController
import com.core.data.network.ApiFactory
import com.core.network.NetworkFactoryInterface
import com.core.preference.DataStores
import com.core.preference.sharedPref.SharedPref
import com.core.utils.FileManager
import javax.inject.Inject

class RegisterRepo @Inject
constructor(
    val apiFactory: ApiFactory,
    dataStore: DataStores,
    networkFactory: NetworkFactoryInterface,
    pref: SharedPref,
    val fileManager: FileManager,
    val usersController: UsersController
) : BaseRepo(dataStore, networkFactory, pref) {
    suspend fun saveUser(
        firstName: String,
        lastName: String,
        age: Int,
        email: String,
        password: String
    ) {
        usersController.insertUserEntity(firstName, lastName, age, email, password)
    }
}
