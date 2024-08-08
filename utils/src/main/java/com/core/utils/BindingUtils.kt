package com.core.utils

import android.os.Build
import android.text.Html
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.Priority
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import de.hdodenhof.circleimageview.CircleImageView
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

    @BindingAdapter("app:bindCategoryIcon", "app:bindSuffix", requireAll = true)
    @JvmStatic
    fun bindCategoryIcon(
        view: CircleImageView,
        prefix: String?,
        suffix: String?
    ) {
        val url = "${prefix}bg_64$suffix"
        Glide.with(view.context).load(url).into(view)
        val options: RequestOptions =
            RequestOptions().centerCrop()
                .error(R.mipmap.ic_launcher)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .priority(Priority.HIGH)

        Glide.with(view.context).load(url)
            .apply(options)
            .into(view)

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

    @BindingAdapter("bindHTML")
    @JvmStatic
    fun bindHTML(textView: TextView, content: String?) {
        content?.run {
            textView.text = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                Html.fromHtml(this, Html.FROM_HTML_MODE_LEGACY)
            } else {
                Html.fromHtml(this)
            }
        }
    }

    @BindingAdapter("bindUserData", "bindDataTitle", requireAll = true)
    @JvmStatic
    fun bindUserData(textView: TextView, data: String?, title: String?) {
        val context = textView.context
        textView.text = String.format(context.getString(R.string.user_data_format), title, data)
    }
}
