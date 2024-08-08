package com.app.app.ui.main.profile

import androidx.fragment.app.viewModels
import com.app.app.BR
import com.app.app.R
import com.app.app.databinding.FragmentProfileBinding
import com.core.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProfileFragment : BaseFragment<FragmentProfileBinding, ProfileViewModel>() {
    val profileViewModel: ProfileViewModel by viewModels()
    override fun bindingVariable(): Int = BR.viewModel

    override fun layoutId(): Int = R.layout.fragment_profile

    override fun getViewModel(): ProfileViewModel = profileViewModel
}