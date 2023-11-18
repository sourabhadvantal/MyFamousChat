package com.advantal.myfamouschat.chat

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.advantal.myfamouschat.chatadapter.ChatMediaAdapter
import com.advantal.myfamouschat.databinding.FragmentChatMediaBinding
import com.advantal.myfamouschat.helpers.BaseFragment
import com.advantal.myfamouschat.utils.RecylerviewItemclick
import dagger.hilt.android.AndroidEntryPoint


/**
 * Chat media fragment
 *
 * @constructor Create empty Chat media fragment
 */
@AndroidEntryPoint
class ChatMediaFragment : BaseFragment() {
    var _binding : FragmentChatMediaBinding?=null

    val binding get() = _binding

    /**
     * On create view
     *
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentChatMediaBinding.inflate(layoutInflater)
        initUI()
        return  _binding!!.root
    }

    /**
     * Init u i
     *
     */
    private fun initUI() {
        binding!!.recUsersmedia.apply {
            layoutManager =GridLayoutManager(requireActivity() ,3)
            adapter = ChatMediaAdapter(object  : RecylerviewItemclick {
                override fun OnitemCLick(itemitem: Any, pos: Int) {

                }

            })
        }

        binding!!.backBtn.setOnClickListener {
            onBackButtonClick()
        }
    }

}