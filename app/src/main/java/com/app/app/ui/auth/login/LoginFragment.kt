package com.app.app.ui.auth.login

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.MutableLiveData
import com.app.app.BR
import com.app.app.R
import com.app.app.databinding.FragmentLoginBinding
import com.app.app.ui.main.MainActivity
import com.core.base.BaseFragment
import com.core.utils.navigateTo
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : BaseFragment<FragmentLoginBinding, LoginViewModel>() {
    val loginViewModel: LoginViewModel by viewModels()

    override fun bindingVariable(): Int = BR.viewModel

    override fun layoutId(): Int = R.layout.fragment_login

    override fun getViewModel(): LoginViewModel = loginViewModel

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?,
    ) {
        super.onViewCreated(view, savedInstanceState)
        registerButtonListener()
        userLoginSuccessObserver()
    }

    private fun registerButtonListener() {
        viewDataBinding.btnRegister.setOnClickListener {
            navigation.navigateTo(R.id.action_loginFragment_to_registerFragment)
        }
    }

    private fun userLoginSuccessObserver() {
        loginViewModel.userLoginSuccess.observe(viewLifecycleOwner) {
            if (it) {
                startActivity(Intent(requireContext(), MainActivity::class.java))
                requireActivity().finish()
            }
        }
    }
}
