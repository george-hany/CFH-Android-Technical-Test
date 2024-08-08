package com.core.data.di

import com.core.data.controlers.UsersController
import com.core.data.network.ApiFactory
import com.core.data.repos.AuthRepo
import com.core.data.repos.HomeRepo
import com.core.data.repos.LoginRepo
import com.core.data.repos.MainRepo
import com.core.data.repos.ProfileRepo
import com.core.data.repos.RegisterRepo
import com.core.network.MockedNetwork
import com.core.network.NetworkFactory
import com.core.network.NetworkFactoryInterface
import com.core.preference.DataStores
import com.core.preference.securedSharedPreferences.SecuredDataStore
import com.core.preference.sharedPref.SharedPref
import com.core.utils.FileManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
class ReposModules {
    @Provides
    @ViewModelScoped
    fun provideMainRepo(
        apiFactory: ApiFactory,
        dataStore: SecuredDataStore,
        mockedNetwork: MockedNetwork,
        pref: SharedPref
    ): MainRepo {
        return MainRepo(
            apiFactory,
            dataStore,
            mockedNetwork,
            pref
        )
    }

    @Provides
    @ViewModelScoped
    fun provideAuthRepo(
        apiFactory: ApiFactory,
        dataStore: DataStores,
        network: NetworkFactoryInterface,
        pref: SharedPref
    ): AuthRepo {
        return AuthRepo(
            apiFactory,
            dataStore,
            network,
            pref
        )
    }

    @Provides
    @ViewModelScoped
    fun provideSplashRepo(
        apiFactory: ApiFactory,
        dataStore: SecuredDataStore,
        networkFactory: NetworkFactory,
        fileManager: FileManager
    ): HomeRepo {
        return HomeRepo(apiFactory, dataStore, networkFactory, fileManager)
    }

    @Provides
    @ViewModelScoped
    fun provideLoginRepo(
        apiFactory: ApiFactory,
        dataStore: SecuredDataStore,
        networkFactory: NetworkFactory,
        fileManager: FileManager,
        usersController: UsersController,
        pref: SharedPref
    ): LoginRepo {
        return LoginRepo(apiFactory, dataStore, networkFactory, fileManager, usersController, pref)
    }

    @Provides
    @ViewModelScoped
    fun provideProfileRepo(
        apiFactory: ApiFactory,
        dataStore: SecuredDataStore,
        networkFactory: NetworkFactory,
        fileManager: FileManager,
        usersController: UsersController,
        pref: SharedPref
    ): ProfileRepo {
        return ProfileRepo(apiFactory, dataStore, networkFactory, fileManager, usersController, pref)
    }

    @Provides
    @ViewModelScoped
    fun provideRegisterRepo(
        apiFactory: ApiFactory,
        dataStore: SecuredDataStore,
        networkFactory: NetworkFactory,
        sharedPref: SharedPref,
        fileManager: FileManager,
        usersController: UsersController
    ): RegisterRepo {
        return RegisterRepo(
            apiFactory,
            dataStore,
            networkFactory,
            sharedPref,
            fileManager,
            usersController
        )
    }
}
