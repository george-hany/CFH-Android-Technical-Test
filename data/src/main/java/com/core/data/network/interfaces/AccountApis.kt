package com.core.data.network.interfaces

import com.core.data.model.home.VenuesResponse
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface AccountApis {
    @GET("venues/search")
    fun getVenuesAsync(
        @Query("ll") ll: String,
        @Query("client_id") clientId: String = "4EQRZPSGKBZGFSERGJY055FRW2OSPJRZYR4C3J0JN2CQQFIV",
        @Query("client_secret") clientSecret: String = "AJR4B5LLRONWAJWJJOACHAFLCWS2YJAZMGQNFFZQP0IB3THR",
        @Query("v") v: String = "20180910",
    ): Deferred<Response<VenuesResponse>>
}
