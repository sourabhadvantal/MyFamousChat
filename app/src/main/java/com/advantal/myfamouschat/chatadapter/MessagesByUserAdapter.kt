package com.advantal.myfamous.view.postonboarding.adapter.chatadapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.advantal.myfamouschat.databinding.ItemMessageByUserBinding
import com.advantal.myfamouschat.utils.RecylerviewItemclick


/**
 * Messages by user adapter
 *
 * @property recylerviewItemclick
 * @constructor Create empty Messages by user adapter
 */
class MessagesByUserAdapter( private val recylerviewItemclick: RecylerviewItemclick) :
    RecyclerView.Adapter<MessagesByUserAdapter.ViewHolder>() {


    /**
     * On create view holder
     *
     * @param parent
     * @param viewType
     * @return
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemMessageByUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
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
    inner class ViewHolder(private val binding: ItemMessageByUserBinding) : RecyclerView.ViewHolder(binding.root) {


        /**
         * Bind
         *
         */
        fun bind() {
            // Your binding logic here
            binding.root.setOnClickListener {
                recylerviewItemclick.OnitemCLick("" , absoluteAdapterPosition)
            }

        }
    }
}