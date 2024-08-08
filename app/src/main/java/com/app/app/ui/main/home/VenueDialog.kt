package com.app.app.ui.main.home

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.Window
import androidx.databinding.DataBindingUtil
import com.app.app.R
import com.app.app.databinding.DialogVenueDetailsBinding
import com.core.data.model.home.Venue

object VenueDetailsDialog {
    fun Context.showVenueDetailsDialog(model: Venue) {
        val dialog = Dialog(this, R.style.PauseDialog)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        val binding: DialogVenueDetailsBinding = DataBindingUtil.inflate(
            LayoutInflater.from(this),
            R.layout.dialog_venue_details,
            null,
            false
        )
        binding.model = model
        binding.category = model.categories?.firstOrNull()

        dialog.setContentView(binding.root)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        val width = (this.resources.displayMetrics.widthPixels * 0.9).toInt()
        dialog.setCanceledOnTouchOutside(true)
        dialog.setCancelable(true)
        dialog.window?.setLayout(
            width,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        dialog.show()
    }
}
