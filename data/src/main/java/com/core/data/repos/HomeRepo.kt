package com.core.data.repos

import com.core.data.base.BaseRepo
import com.core.data.network.ApiFactory
import com.core.network.NetworkFactoryInterface
import com.core.preference.DataStores
import javax.inject.Inject

class HomeRepo
    @Inject
    constructor(
        apiFactory: ApiFactory,
        dataStore: DataStores,
        networkFactory: NetworkFactoryInterface,
    ) : BaseRepo(dataStore, networkFactory)
