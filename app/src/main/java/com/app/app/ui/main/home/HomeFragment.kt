package com.app.app.ui.main.home

import android.Manifest
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.fragment.app.viewModels
import com.app.app.BR
import com.app.app.R
import com.app.app.databinding.FragmentHomeBinding
import com.app.app.ui.main.home.VenueDetailsDialog.showVenueDetailsDialog
import com.app.app.ui.main.home.adapter.VenuesListAdapter
import com.core.base.BaseFragment
import com.core.data.model.home.Venue
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.tasks.OnSuccessListener
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>() {
    val homeViewModel: HomeViewModel by viewModels()
    private var fusedLocationClient: FusedLocationProviderClient? = null
    private val requestPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()
    ) { permissions ->
        val fineLocationGranted = permissions[Manifest.permission.ACCESS_FINE_LOCATION] ?: false
        val coarseLocationGranted = permissions[Manifest.permission.ACCESS_COARSE_LOCATION] ?: false
        checkLocationPermission()
    }

    private fun checkLocationPermission() {
        if (ActivityCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            requestPermissionLauncher.launch(
                arrayOf(
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_COARSE_LOCATION
                )
            )
        } else {
            fetchLocation()
        }
    }

    @SuppressLint("MissingPermission")
    private fun fetchLocation() {
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(requireActivity())
        fusedLocationClient?.lastLocation?.addOnSuccessListener(requireActivity()) { location ->
            if (location != null) {
                val latitude = location.latitude
                val longitude = location.longitude
                homeViewModel.getVenuesList(latitude, longitude)
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        checkLocationPermission()
        venuesListObserver()
        setupVenuesListAdapter()
    }

    private fun setupVenuesListAdapter() {
        viewDataBinding.adapter = VenuesListAdapter(object : VenuesListAdapter.ClickListener {
            override fun onItemClick(model: Venue) {
                requireContext().showVenueDetailsDialog(model)
            }
        })
    }

    private fun venuesListObserver() {
        homeViewModel.venuesList.observe(viewLifecycleOwner) {
            viewDataBinding.adapter?.submitList(it)
        }
    }

    override fun bindingVariable(): Int = BR.viewModel

    override fun layoutId(): Int = R.layout.fragment_home

    override fun getViewModel(): HomeViewModel = homeViewModel
}
