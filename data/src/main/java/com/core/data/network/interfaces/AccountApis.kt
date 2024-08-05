package com.core.data.network.interfaces

import com.core.data.model.login.MoviesResponse
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.POST

interface AccountApis {
    @POST("movie/popular?api_key=777660159186d81259c9dcfa910ad0f1&page=")
    fun loginAsync(): Deferred<Response<MoviesResponse>>
}
