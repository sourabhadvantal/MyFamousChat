package com.advantal.myfamouschat.chat


import android.annotation.SuppressLint
import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.advantal.myfamous.data.chat.ChatUserModel
import com.advantal.myfamouschat.bottomsheets.BottomSheetDialogDeleteChat
import com.advantal.myfamous.view.postonboarding.adapter.chatadapter.AllUserChatHomeAdapter
import com.advantal.myfamouschat.R
import com.advantal.myfamouschat.databinding.FragmentChatHomeBinding

import com.advantal.myfamouschat.helpers.BaseFragment
import com.advantal.myfamouschat.utils.Helper
import com.advantal.myfamouschat.utils.RecylerviewItemclick
import com.advantal.myfamouschat.viewmodels.chat.ChatViewModel
import dagger.hilt.android.AndroidEntryPoint


/**
 * Chat home fragment
 *
 * @constructor Create empty Chat home fragment
 */
@AndroidEntryPoint
class ChatHomeFragment : BaseFragment()  ,View.OnClickListener{

//    private  var filterDataList: ArrayList <MutableLiveData< ChatUserModel>> = ArrayList()
    private  var filterDataList: ArrayList <ChatUserModel> = ArrayList()
    var _binding : FragmentChatHomeBinding?=null
    val binding get() = _binding
    private var allUserAdapter : AllUserChatHomeAdapter?=null
    var isUserTobeDeleted :Boolean = false
    val viewModel : ChatViewModel by viewModels()
    /**
     * On create view
     *
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        initializeNavigation(requireActivity())

        // Inflate the layout for this fragment
        _binding = FragmentChatHomeBinding.inflate(layoutInflater)
        initUI();


        return  binding!!.root
    }


    override fun onResume() {
        super.onResume()
        Helper.convertStatusBarAndBottomBarWithColor(requireActivity() ,R.color.chat_background_color,R.color.ic_chat_list_back_color)

    }
    /**
     * On destroy
     *
     */
    override fun onDestroy() {
        requireActivity().window.statusBarColor = resources.getColor(R.color.white)
        requireActivity().window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        requireActivity().window.clearFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        val nightModeFlags: Int = this.getResources().getConfiguration().uiMode and
                Configuration.UI_MODE_NIGHT_MASK
        when (nightModeFlags) {
            Configuration.UI_MODE_NIGHT_YES -> {
                Helper.convertStatusBar(requireActivity() ,false ,false,6 ,1)
            }
            Configuration.UI_MODE_NIGHT_NO -> {
                Helper.convertStatusBar(requireActivity() ,false ,false,6 ,0)
            }
            Configuration.UI_MODE_NIGHT_UNDEFINED -> {}
        }
        _binding = null;
        super.onDestroy()

    }
    private fun initUI() {

        allUserAdapter =  AllUserChatHomeAdapter( viewModel.getChatUserModel(),object :
            RecylerviewItemclick {
            @SuppressLint("NewApi")
            override fun OnitemCLick(itemitem: Any, pos: Int) {
                if(!isUserTobeDeleted)
                {
                    navigateToScreen(R.id.action_nav_fragment_chat_home_to_nav_fragment_user_message ,null)
                    return
                }

                val item = itemitem as ChatUserModel
                Log.e("navigateToScreen" , ""+item.name)
                Log.e("navigateToScreen" , ""+item.isSelected)
//                val mutablesample : MutableLiveData<ChatViewModel> = MutableLiveData()
//                mutablesample.postValue(item)
                if(item.isSelected)
                {
                    filterDataList.add(item)
                }else{
                    filterDataList.remove(item)
                }
                if(filterDataList.size>0)
                {
                    binding!!.tvSelectedItemDone.visibility =View.VISIBLE
                    binding!!.tvSelectedItemDone.text = "${filterDataList.size} Selected"
                    binding!!.tvDeleteAll.setTextColor(requireActivity().resources.getColor(R.color.text_color_chat_blue_full,null))
                }else{
                    binding!!.tvDeleteAll.setTextColor(requireActivity().resources.getColor(R.color.text_color_chat_grey_36,null))

                    binding!!.tvSelectedItemDone.visibility =View.GONE
                }

            }

        } ,false)
        binding!!.recAlluserChats.apply {
            layoutManager = LinearLayoutManager(requireActivity() )
           adapter = allUserAdapter
        }
        binding!!.rlEditChat.setOnClickListener(this)
        binding!!.tvSelectedItemDone.setOnClickListener(this)
        binding!!.tvSelectedItemCancel.setOnClickListener(this)
        binding!!.tvDeleteAll.setOnClickListener(this)
        binding!!.backBtn.setOnClickListener {
            onBackButtonClick()
        }



    }

    private fun showBottomSheetDialogDelete() {

if(filterDataList.size <=0)
{
    return
}
//        binding!!.liBottomSendfiles.visibility = if(binding!!.liBottomSendfiles.visibility == View.VISIBLE) View.GONE else View.VISIBLE
        val bottomSheetFragment = BottomSheetDialogDeleteChat()
        bottomSheetFragment.mContext = requireContext()
        bottomSheetFragment.setOnCompleteListener(
            object : BottomSheetDialogDeleteChat.OnCompleteListener{
                override fun OnCancelTap(pos: Int) {

                }

                override fun OnOptionTap(pos: Int) {

                }


            })
        bottomSheetFragment.show(requireActivity().supportFragmentManager, bottomSheetFragment.tag)

    }
    override fun onClick(p0: View?) {
     when(p0?.id)
     {
//         R.id.rl_chat_camera -> navigateToScreen(R.id.action_nav_fragment_chat_home_to_nav_camera_frags ,null)
         R.id.rl_edit_chat -> editChat()
         R.id.tv_selected_item_cancel -> doneSelection()
         R.id.tv_delete_all -> showBottomSheetDialogDelete()
     }
    }

    /**
     * Done selection
     *
     */
    private fun doneSelection() {
        isUserTobeDeleted = false
        allUserAdapter?.editOrDeleteChat(false)
        binding?.rlUserChatOption?.visibility =View.VISIBLE
        binding?.rlDeleteBottom?.visibility =View.GONE
        binding?.tvSelectedItemDone?.visibility =View.GONE
        binding?.rlDoneorcanceloptions?.visibility =View.GONE
    }

    private fun editChat() {
        isUserTobeDeleted = true
        allUserAdapter?.editOrDeleteChat(true)
        binding?.rlUserChatOption?.visibility =View.GONE
        binding?.tvSelectedItemDone?.visibility =View.VISIBLE
        binding?.rlDeleteBottom?.visibility =View.VISIBLE
        binding?.rlDoneorcanceloptions?.visibility =View.VISIBLE
    }
}