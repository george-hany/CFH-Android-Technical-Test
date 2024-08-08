package com.app.app.ui.auth.register

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.app.app.BR
import com.app.app.R
import com.app.app.databinding.FragmentRegisterBinding
import com.app.app.ui.main.MainActivity
import com.core.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterFragment : BaseFragment<FragmentRegisterBinding, RegisterViewModel>() {
    val registerViewModel: RegisterViewModel by viewModels()
    override fun bindingVariable(): Int = BR.viewModel

    override fun layoutId(): Int = R.layout.fragment_register

    override fun getViewModel(): RegisterViewModel = registerViewModel

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?,
    ) {
        super.onViewCreated(view, savedInstanceState)
        userRegisterSuccessObserver()
    }

    private fun userRegisterSuccessObserver() {
        registerViewModel.userRegisterSuccess.observe(viewLifecycleOwner) {
            if (it)
                navigation.navigateUp()
        }
    }
}