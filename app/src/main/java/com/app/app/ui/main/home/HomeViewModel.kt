package com.app.app.ui.main.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.core.base.BaseViewModel
import com.core.data.model.home.Venue
import com.core.data.network.model.ResponseState
import com.core.data.repos.HomeRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel
@Inject
constructor(val repo: HomeRepo) : BaseViewModel<HomeRepo>(repo) {
    private val _venuesList = MutableLiveData<List<Venue?>?>()
    val venuesList: LiveData<List<Venue?>?> get() = _venuesList
    fun getVenuesList(latitude: Double, longitude: Double) {
        viewModelScope.launch {
            repo.requestVenuesList(lat = latitude, long = longitude).collect {
                isLoading.value = it is ResponseState.Loading
                when (it) {
                    is ResponseState.Success -> _venuesList.value = it.data?.response?.venues
                    is ResponseState.Error -> message.value = it.message
                    is ResponseState.Loading -> isLoading.value = true
                }
            }
        }
    }
}
