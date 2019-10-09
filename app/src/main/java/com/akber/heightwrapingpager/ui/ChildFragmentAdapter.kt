package com.akber.heightwrapingpager.ui

import android.content.Context
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.akber.heightwrapingpager.R
import kotlinx.android.synthetic.main.list_item.view.*

class ChildFragmentAdapter(private val context: Context?, private val data: ArrayList<String>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    companion object {
        const val VIEW_TYPE_DUMMY = 0
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            VIEW_TYPE_DUMMY -> RecentInvitesViewHolder(
                LayoutInflater.from(context).inflate(
                    R.layout.list_item,
                    parent,
                    false
                )
            )
            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val feed: String = getItem(position)
        when (holder) {
            is RecentInvitesViewHolder -> showRecentInvites(holder, feed, position)
        }
    }


    private fun showRecentInvites(holder: RecentInvitesViewHolder, feed: String, position: Int) {
        holder.name.text = feed
        holder.phone.text = "+92 3215068124"
        holder.expiresIn.text = context?.getString(R.string.expires_in)
        holder.expiresInValue.text = "00:24:30"
        holder.image.setOnClickListener {
            removeItem(position)
        }
    }


    override fun getItemCount(): Int {
        return data.size
    }

    private fun getItem(position: Int): String {
        return data[position]
    }


    override fun getItemViewType(position: Int): Int {

        return VIEW_TYPE_DUMMY
    }


    fun update(data: ArrayList<String>) {
        this.data.clear()
        this.data.addAll(data)
        notifyDataSetChanged()
    }

    private fun removeItem(position: Int) {
        this.data.remove(this.data[position])
        notifyDataSetChanged()
    }

    inner class RecentInvitesViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val clItem: ConstraintLayout = view.clItem
        val image: ImageView = view.image
        val name: TextView = view.title
        val expiresIn: TextView = view.title_end
        val phone: TextView = view.sub_title
        val expiresInValue: TextView = view.sub_title_end
    }

}