package com.app.app.ui.auth

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.content.ContentProviderCompat.requireContext
import com.app.app.BR
import com.app.app.R
import com.app.app.app.MyApp
import com.app.app.databinding.ActivityAuthBinding
import com.app.app.ui.main.MainActivity
import com.core.base.BaseActivity
import com.core.utils.LangUtil.setLanguage
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AuthActivity : BaseActivity<ActivityAuthBinding, AuthViewModel>() {
    private val authViewModel: AuthViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        checkUserLoginStates()
    }

    private fun checkUserLoginStates() {
        val isUserLoggedIn = authViewModel.isUserLoggedIn()
        if (isUserLoggedIn) {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }

    override fun bindingVariable(): Int {
        return BR.viewModel
    }

    override fun layoutId(): Int {
        return R.layout.activity_auth
    }

    override fun controllerId(): Int {
        return R.id.authController
    }

    override fun getViewModel(): AuthViewModel {
        return authViewModel
    }

    override fun setupLanguage() {
        val lang = MyApp.pref.getLang()
        setLanguage(lang)
    }
}
