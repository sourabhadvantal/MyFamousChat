package com.advantal.myfamous.view.postonboarding.adapter.chatadapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.advantal.myfamous.data.chat.AllMessagesModel
import com.advantal.myfamouschat.databinding.ItemMessageByUserBinding
import com.advantal.myfamouschat.utils.RecylerviewItemclick

/**
 * User message adapter
 *
 * @property datalist
 * @property recylerviewItemclick
 * @constructor Create empty User message adapter
 */
class UserMessageAdapter(
    var datalist: ArrayList<AllMessagesModel>,
    private val recylerviewItemclick: RecylerviewItemclick
) :
    RecyclerView.Adapter<UserMessageAdapter.ViewHolder>() {

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
        return datalist.size
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
            if(absoluteAdapterPosition !=0)
            {
                binding.rlTimeofmessage.visibility =View.GONE
            }
//            var mycolor = binding.root.context.resources.getColor(R.color.button_gradcol_left,null)
            if(datalist[absoluteAdapterPosition].type ==1)
            {
                binding.tvMessageReceiver.text = datalist[absoluteAdapterPosition].message
                binding.liMessageReceiver.visibility =View.VISIBLE
                binding.liMessageSender.visibility =View.GONE
            }else{
                binding.tvMessageSender.text = datalist[absoluteAdapterPosition].message
                binding.liMessageSender.visibility =View.VISIBLE
                binding.liSenderText.visibility =View.VISIBLE
                binding.liMessageReceiver.visibility =View.GONE
            }
        if(datalist[absoluteAdapterPosition].isImage)
        {
            binding.liSenderImage.visibility = View.VISIBLE
            binding.liSenderText.visibility =View.GONE

        }else{
            binding.liSenderImage.visibility = View.GONE
            binding.liSenderText.visibility =View.VISIBLE
            binding.tvMessageSender.text = datalist[absoluteAdapterPosition].message
        }


            // Your binding logic here
        binding.root.setOnClickListener {
            recylerviewItemclick.OnitemCLick("" , absoluteAdapterPosition)
        }
//            binding.recMessagebyUsers.apply {
//                layoutManager =LinearLayoutManager(binding.root.context )
//                adapter = MessagesByUserAdapter(object :RecylerviewItemclick{
//                    override fun OnitemCLick(itemitem: Any, pos: Int) {
//
//                    }
//
//                })
//            }
        }
    }
}