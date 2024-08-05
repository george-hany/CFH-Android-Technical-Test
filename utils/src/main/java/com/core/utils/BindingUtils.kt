package com.core.utils

import android.widget.EditText
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import timber.log.Timber

object BindingUtils {
    @BindingAdapter("app:error")
    @JvmStatic
    fun bindError(
        view: EditText,
        error: String?,
    ) {
        if (error != null) {
            Timber.tag("Error").e(error)
            view.error = error
            view.requestFocus()
        }
    }

    @BindingAdapter("app:image")
    @JvmStatic
    fun bindImage(
        view: ImageView,
        url: String?,
    ) {
        if (url != null) {
            Glide.with(view.context).load(url).into(view)
        }
    }

    @BindingAdapter("app:adapter")
    @JvmStatic
    fun bindAdapter(
        view: RecyclerView,
        adapter: Any?,
    ) {
        if (adapter != null) {
            view.adapter = adapter as RecyclerView.Adapter<*>?
        }
    }
}
