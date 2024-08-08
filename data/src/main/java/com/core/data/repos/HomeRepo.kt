package com.core.data.repos

import com.core.data.base.BaseRepo
import com.core.data.model.home.VenuesResponse
import com.core.data.network.ApiFactory
import com.core.data.network.NetworkBoundFileResource
import com.core.data.network.model.ResponseState
import com.core.data.strategy.DataStrategy
import com.core.network.NetworkFactoryInterface
import com.core.preference.DataStores
import com.core.utils.FileManager
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.flow.MutableStateFlow
import retrofit2.Response
import javax.inject.Inject

class HomeRepo
@Inject
constructor(
    val apiFactory: ApiFactory,
    dataStore: DataStores,
    networkFactory: NetworkFactoryInterface,
    val fileManager: FileManager
) : BaseRepo(dataStore, networkFactory) {

    fun requestVenuesList(
        lat: Double,
        long: Double
    ): MutableStateFlow<ResponseState<VenuesResponse?>> {
        return object : NetworkBoundFileResource<VenuesResponse>(
            networkFactory,
            fileName = "VenuesList.json",
            fileManager = fileManager,
            strategy = DataStrategy.Strategies.DEFAULT_STRATEGY
        ) {
            override fun convert(json: String): VenuesResponse? {
                return Gson().fromJson(json, object : TypeToken<VenuesResponse>() {}.type)
            }

            override suspend fun createCall(): suspend () -> Response<VenuesResponse> =
                {
                    apiFactory.getAccountApis().getVenuesAsync(ll = "$lat,$long").await()
                }
        }.asFlow()
    }
}
