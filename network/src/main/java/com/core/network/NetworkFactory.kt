package com.core.network

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import com.core.network.model.Result
import retrofit2.Response
import javax.inject.Inject

class NetworkFactory
    @Inject
    constructor(var context: Context) :
    NetworkFactoryInterface {
        override fun isNetworkConnected(): Boolean {
            val connectivityManager =
                context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                val nw = connectivityManager.activeNetwork ?: return false
                val actNw = connectivityManager.getNetworkCapabilities(nw) ?: return false
                return when {
                    actNw.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
                    actNw.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
                    // for other device how are able to connect with Ethernet
                    actNw.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
                    // for check internet over Bluetooth
                    actNw.hasTransport(NetworkCapabilities.TRANSPORT_BLUETOOTH) -> true
                    else -> false
                }
            } else {
                return connectivityManager.activeNetworkInfo?.isConnected ?: false
            }
        }

        override suspend fun <T : Any> makeRequest(
            call: suspend () -> Response<T>,
            errorMessage: String,
        ): Result<T> {
            return safeApiResult(call, errorMessage)
        }

        private suspend fun <T : Any> safeApiResult(
            call: suspend () -> Response<T>,
            errorMessage: String,
        ): Result<T> {
            val response = call.invoke()
            if (response.isSuccessful) return Result.Success(response)
            return Result.Error(response)
        }
    }
