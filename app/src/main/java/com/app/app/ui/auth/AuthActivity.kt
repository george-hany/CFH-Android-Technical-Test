package com.app.app.ui.auth

import androidx.activity.viewModels
import com.app.app.BR
import com.app.app.R
import com.app.app.app.MyApp
import com.app.app.databinding.ActivityAuthBinding
import com.core.base.BaseActivity
import com.core.utils.LangUtil.setLanguage
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AuthActivity : BaseActivity<ActivityAuthBinding, AuthViewModel>() {
    private val authViewModel: AuthViewModel by viewModels()

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
