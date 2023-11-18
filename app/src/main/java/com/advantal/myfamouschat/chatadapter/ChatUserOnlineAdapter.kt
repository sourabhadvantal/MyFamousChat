package com.advantal.myfamouschat.chatadapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.advantal.myfamouschat.R
import com.advantal.myfamouschat.databinding.ItemChatOnlineListBinding
import com.advantal.myfamouschat.utils.RecylerviewItemclick

/**
 * Chat user online adapter
 *
 * @property recylerviewItemclick
 * @constructor Create empty Chat user online adapter
 */
class ChatUserOnlineAdapter(private val recylerviewItemclick: RecylerviewItemclick) :
    RecyclerView.Adapter<ChatUserOnlineAdapter.ViewHolder>() {


    /**
     * On create view holder
     *
     * @param parent
     * @param viewType
     * @return
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemChatOnlineListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
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
    inner class ViewHolder(private val binding: ItemChatOnlineListBinding) : RecyclerView.ViewHolder(binding.root) {


        /**
         * Bind
         *
         */
        fun bind() {
            when(absoluteAdapterPosition )
            {
                0 -> {
                    binding.tvOnlineusername.text = "Messi"
                    binding.ivUserImage.setImageResource(R.drawable.ic_sara_big)
                }
                1 -> {
                    binding.tvOnlineusername.text = "Sara"
                    binding.ivUserImage.setImageResource(R.drawable.ic_profile)
                }
                2 -> {
                    binding.tvOnlineusername.text = "Ahmed"
                    binding.ivUserImage.setImageResource(R.drawable.ic_profile)
                }
                3 -> {
                    binding.tvOnlineusername.text = "Salma"
                    binding.ivUserImage.setImageResource(R.drawable.ic_profile)
                }
                4 -> {
                    binding.tvOnlineusername.text = "Fahad"
                    binding.ivUserImage.setImageResource(R.drawable.ic_profile)
                }
            }
            // Your binding logic here
            recylerviewItemclick.OnitemCLick("" , absoluteAdapterPosition)
        }
    }
}