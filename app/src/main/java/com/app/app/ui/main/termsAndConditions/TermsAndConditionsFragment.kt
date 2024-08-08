package com.app.app.ui.main.termsAndConditions

import androidx.fragment.app.viewModels
import com.app.app.BR
import com.app.app.R
import com.app.app.databinding.FragmentTermsAndConditionsBinding
import com.core.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TermsAndConditionsFragment :
    BaseFragment<FragmentTermsAndConditionsBinding, TermsAndConditionsViewModel>() {
    val termsAndConditionsViewModel: TermsAndConditionsViewModel by viewModels()
    override fun bindingVariable(): Int = BR.viewModel

    override fun layoutId(): Int = R.layout.fragment_terms_and_conditions

    override fun getViewModel(): TermsAndConditionsViewModel = termsAndConditionsViewModel

}