package com.app.app.ui.main

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.appcompat.widget.Toolbar
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.onNavDestinationSelected
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.app.app.BR
import com.app.app.R
import com.app.app.app.MyApp.Companion.pref
import com.app.app.databinding.ActivityMainBinding
import com.app.app.ui.auth.AuthActivity
import com.core.base.BaseActivity
import com.core.utils.LangUtil.setLanguage
import com.google.android.material.navigation.NavigationView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>(),
    NavigationView.OnNavigationItemSelectedListener {
    val mainViewModel: MainViewModel by viewModels()
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupNavigationDrawer()
    }

    private fun setupNavigationDrawer() {
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(viewDataBinding.appBarDrawer.toolbar)
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home,
                R.id.nav_profile,
                R.id.nav_terms_and_conditions,
                R.id.nav_terms_and_conditions
            ), viewDataBinding.drawerLayout
        )
        setupActionBarWithNavController(navigation, appBarConfiguration)
        viewDataBinding.navView.setupWithNavController(navigation)
        viewDataBinding.navView.setNavigationItemSelectedListener(this)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navigation.navigateUp(appBarConfiguration) || super.onSupportNavigateUp() || navigation.navigateUp()
    }

    private fun applyLogout() {
        mainViewModel.clearUserEmail()
        startActivity(Intent(this, AuthActivity::class.java))
        finish()
//        showMessage("logout")
    }

    override fun bindingVariable(): Int {
        return BR.viewModel
    }

    override fun layoutId(): Int {
        return R.layout.activity_main
    }

    override fun controllerId(): Int {
        return R.id.nav_host_fragment_content_drawer
    }

    override fun getViewModel(): MainViewModel {
        return mainViewModel
    }

    override fun setupLanguage() {
        val lang = pref.getLang()
        setLanguage(lang)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.nav_logout) {
            applyLogout()
            return true
        }
        return false
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.nav_logout) {
            applyLogout()
            return true
        }
        viewDataBinding.drawerLayout.closeDrawers()
        return true
    }
}
