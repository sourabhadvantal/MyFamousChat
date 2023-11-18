package com.advantal.myfamous.view.postonboarding.adapter.chatadapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.advantal.myfamous.data.chat.ChatUserModel
import com.advantal.myfamouschat.databinding.ItemChatHomeBinding
import com.advantal.myfamouschat.utils.RecylerviewItemclick

//import com.advantal.myfamous.databinding.ItemChatHomeBinding
//import com.advantal.myfamous.utilities.CustomAlertDialog
//import com.advantal.myfamous.utilities.RecylerviewItemclick


/**
 * All user chat home adapter
 *
 * @property recylerviewItemclick
 * @constructor Create empty All user chat home adapter
 */
class AllUserChatHomeAdapter(
    var datalist: ArrayList<ChatUserModel>,
    private val recylerviewItemclick: RecylerviewItemclick,
    var isUserTobeDeleted :Boolean

    ) :
    RecyclerView.Adapter<AllUserChatHomeAdapter.ViewHolder>() {

    /**
     * On create view holder
     *
     * @param parent
     * @param viewType
     * @return
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemChatHomeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
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
        return datalist.size
    }


    fun editOrDeleteChat(b: Boolean) {
        isUserTobeDeleted = b;
        notifyDataSetChanged()
    }

    /**
     * View holder
     *
     * @property binding
     * @constructor Create empty View holder
     */
    inner class ViewHolder(private val binding: ItemChatHomeBinding) :
        RecyclerView.ViewHolder(binding.root) {


        /**
         * Bind
         *
         */
        fun bind() {
            binding.ivUserImage.setImageResource(datalist[absoluteAdapterPosition].imageraw)
            if(isUserTobeDeleted)
            {
                binding.rlMessageCount.visibility =View.GONE
            }
            // Your binding logic here
            binding.coChatView.setOnClickListener {
                if (!isUserTobeDeleted)
                    recylerviewItemclick.OnitemCLick("", absoluteAdapterPosition)
            }
            binding.tvUserName.setText(datalist[absoluteAdapterPosition].name)
            binding.tvSeetime.setText(datalist[absoluteAdapterPosition].description)
            binding.cbDeleteOrNot.setOnCheckedChangeListener { compoundButton, b ->
                var listmodel = datalist[absoluteAdapterPosition]
                listmodel.isSelected = binding.cbDeleteOrNot.isChecked
                recylerviewItemclick.OnitemCLick(listmodel, absoluteAdapterPosition)


            }
//            binding.cbDeleteOrNot.setOnClickListener {
////                binding.cbDeleteOrNot.isChecked = !binding.cbDeleteOrNot.isChecked
//
//            }
            if (isUserTobeDeleted) {
                binding.cbDeleteOrNot.visibility = View.VISIBLE
            }else{
                binding.cbDeleteOrNot.visibility = View.GONE
            }

        }
    }
}