package com.app.app.ui.main.home.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.app.app.databinding.VenuesItemBinding
import com.core.base.BaseViewHolder
import com.core.data.model.home.Venue

class VenuesListAdapter(private val clickListener: ClickListener) :
    ListAdapter<Venue, BaseViewHolder>(
        USER_COMPARATOR
    ) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return ViewHolder(
            VenuesItemBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.onBind(position)
    }

    override fun getItemViewType(position: Int): Int {
        return if (position == 0) 0 else 1
    }

    inner class ViewHolder(var binding: VenuesItemBinding) :
        BaseViewHolder(binding.root) {
        override fun onBind(position: Int) {
            binding.run {
                model = getItem(position)
                listener = clickListener
            }
        }
    }

    companion object {
        private val USER_COMPARATOR = object : DiffUtil.ItemCallback<Venue>() {
            override fun areItemsTheSame(
                oldItem: Venue,
                newItem: Venue
            ): Boolean =
                newItem.id == oldItem.id

            @SuppressLint("DiffUtilEquals")
            override fun areContentsTheSame(
                oldItem: Venue,
                newItem: Venue
            ): Boolean =
                newItem == oldItem
        }
    }

    interface ClickListener {
        fun onItemClick(model: Venue)
    }
}
