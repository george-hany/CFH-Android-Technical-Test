package com.app.app.ui.main.home

import androidx.fragment.app.viewModels
import com.app.app.BR
import com.app.app.R
import com.app.app.databinding.FragmentHomeBinding
import com.core.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>() {
    val homeViewModel: HomeViewModel by viewModels()

    override fun bindingVariable(): Int = BR.viewModel

    override fun layoutId(): Int = R.layout.fragment_home

    override fun getViewModel(): HomeViewModel = homeViewModel
}
