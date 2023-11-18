package com.advantal.myfamouschat.chatadapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.advantal.myfamouschat.R
import com.advantal.myfamouschat.databinding.ItemBettweenusermediaBinding
import com.advantal.myfamouschat.utils.RecylerviewItemclick
import com.bumptech.glide.Glide

//import com.advantal.myfamous.R
//import com.advantal.myfamous.databinding.ItemBettweenusermediaBinding
//import com.advantal.myfamous.databinding.ItemChatHomeBinding
//import com.advantal.myfamous.utilities.CustomAlertDialog
//import com.advantal.myfamous.utilities.RecylerviewItemclick
//import com.bumptech.glide.Glide

/**
 * Chat media adapter
 *
 * @property recylerviewItemclick
 * @constructor Create empty Chat media adapter
 */
class ChatMediaAdapter(private val recylerviewItemclick: RecylerviewItemclick) :
    RecyclerView.Adapter<ChatMediaAdapter.ViewHolder>() {


    /**
     * On create view holder
     *
     * @param parent
     * @param viewType
     * @return
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemBettweenusermediaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    /**
     * On bind view holder
     *
     * @param holder
     * @param position
     */
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind()
    }

    /**
     * Get item count
     *
     * @return
     */
    override fun getItemCount(): Int {
        return 6
    }

    /**
     * View holder
     *
     * @property binding
     * @constructor Create empty View holder
     */
    inner class ViewHolder(private val binding: ItemBettweenusermediaBinding) : RecyclerView.ViewHolder(binding.root) {


        /**
         * Bind
         *
         */
        fun bind() {
            // Your binding logic here
            binding!!.root.setOnClickListener {
                recylerviewItemclick.OnitemCLick("" , absoluteAdapterPosition)
            }
            when(bindingAdapterPosition)
            {
                0 -> {
                    Glide.with(binding!!.root.context).load(R.drawable.ic_profile)
                        .error(R.drawable.ic_profile)
                        .into(binding.ivMedia)

                }

            }


        }
    }
}