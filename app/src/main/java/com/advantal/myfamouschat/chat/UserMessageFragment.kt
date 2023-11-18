package com.advantal.myfamouschat.chat

import android.content.res.Configuration
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.advantal.myfamous.view.postonboarding.adapter.chatadapter.UserMessageAdapter
import com.advantal.myfamouschat.R
import com.advantal.myfamouschat.bottomsheets.BottomSheetDialogBlock
import com.advantal.myfamouschat.bottomsheets.BottomSheetDialogChangeWallpaper
import com.advantal.myfamouschat.bottomsheets.BottomSheetDialogChatOptions
import com.advantal.myfamouschat.bottomsheets.BottomSheetDialogClearChat
import com.advantal.myfamouschat.bottomsheets.BottomSheetDialogDeleteChat
import com.advantal.myfamouschat.databinding.FragmentUserMessageBinding
import com.advantal.myfamouschat.helpers.BaseFragment
import com.advantal.myfamouschat.utils.AppConstant
import com.advantal.myfamouschat.utils.Helper
import com.advantal.myfamouschat.utils.RecylerviewItemclick
import com.advantal.myfamouschat.viewmodels.chat.ChatViewModel
import dagger.hilt.android.AndroidEntryPoint


/**
 * User message fragment
 *
 * @constructor Create empty User message fragment
 */
@AndroidEntryPoint
class UserMessageFragment : BaseFragment() {
    var _binding : FragmentUserMessageBinding?=null

    val viewModel : ChatViewModel by viewModels()
    /**
     * Binding
     */
    val binding get() = _binding

    private val pickImageLauncher = registerForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
        if (uri != null) {
            // Process the selected image
            // For example, you can display it in an ImageView

        }
    }

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
    ): View {
        initializeNavigation(requireActivity())
        // Inflate the layout for this fragment
        _binding = FragmentUserMessageBinding.inflate(layoutInflater)
        initUI();


        return _binding!!.root
//        return inflater.inflate(R.layout.fragment_user_message, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(isAdded)
        {

                binding?.root?.viewTreeObserver?.addOnGlobalLayoutListener {
                    try{
                        val heightDiff: Int = binding?.root?.rootView?.height!! - binding?.root?.height!!
                        if (heightDiff > dpToPix(requireActivity(), 100F)
                        ) { // if more than 200 dp, it's probably a keyboard...
                            // ... do something here
                            Log.e("Keyboard", "Has Opened")
                            binding!!.liChatSendOptions.visibility =View.GONE
                            binding!!.rlSendMessageChat.visibility =View.VISIBLE
                            binding!!.rlChatCamera.visibility =View.GONE
//                binding!!.liBottomSendfiles.visibility =View.VISIBLE

                        } else {
                            Log.e("Keyboard", "Has Not Opened")
                            binding!!.liChatSendOptions.visibility =View.VISIBLE
                            binding!!.rlSendMessageChat.visibility =View.GONE
                            binding!!.rlChatCamera.visibility =View.VISIBLE
//                binding!!.liBottomSendfiles.visibility =View.GONE
                        }
                    }catch (_:Exception){

                    }

                }

        }

    }

    override fun onResume() {
        super.onResume()
        Helper.convertStatusBarAndBottomBarWithColor(requireActivity() ,R.color.chat_background_color,R.color.chat_background_color)
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


    /**
     * Init u i
     *
     */
    private fun initUI() {

        binding!!.backBtn.setOnClickListener {
            onBackButtonClick()
        }

        binding!!.recMessages.apply {
            layoutManager =LinearLayoutManager(requireActivity())
            adapter =  UserMessageAdapter(viewModel.getAllMessagesModel() ,object :
                RecylerviewItemclick {
                override fun OnitemCLick(itemitem: Any, pos: Int) {


                }

            })
        }
        binding!!.rlChatCamera.setOnClickListener {
            val bundle = Bundle()
            bundle.putInt(AppConstant.CALL_POSITION,0)
            navigateToScreen(R.id.action_nav_fragment_user_message_to_nav_fragment_call_initial ,bundle)
        }
        binding!!.icVideoCall.setOnClickListener {
            val bundle = Bundle()
            bundle.putInt(AppConstant.CALL_POSITION,1)
            navigateToScreen(R.id.action_nav_fragment_user_message_to_nav_fragment_call_initial ,bundle)
        }

//        binding!!.rlSendfiles.setOnClickListener{
//           showBottomSheetDialogForSend()
//        }
//        binding!!.rlThreeDots.setOnClickListener {
//            showBottomSheetDialog()
//        }
    }

    /**
     * Show bottom sheet dialog for send
     *
     */
    private fun showBottomSheetDialogDelete() {

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

    /**
     * Show bottom sheet dialog
     *
     */
    private fun showBottomSheetDialog() {
        val bottomSheetFragment = BottomSheetDialogChatOptions()
        bottomSheetFragment.mContext = requireContext()
        bottomSheetFragment.setOnCompleteListener(
            object : BottomSheetDialogChatOptions.OnCompleteListener{
                override fun OnCancelTap(pos: Int) {

                }

                override fun OnOptionTap(pos: Int) {
                    if(pos ==2)
                    {
                        val bottomSheetFragmentchangewall = BottomSheetDialogChangeWallpaper()
                        bottomSheetFragmentchangewall.mContext = requireContext()
                        bottomSheetFragmentchangewall.setOnCompleteListener(object :BottomSheetDialogChangeWallpaper.OnCompleteListener{
                            override fun OnCancelTap(pos: Int) {

                            }

                            override fun OnOptionTap(pos: Int) {

                            }

                        })
                        bottomSheetFragmentchangewall.show(requireActivity().supportFragmentManager, bottomSheetFragment.tag)
                    }
                   else if(pos ==3)
                    {

                        navigateToScreen(R.id.action_nav_fragment_user_message_to_nav_fragment_chat_media ,null)
                    }
                    else if(pos ==4)
                    {
                        val bottomSheetFragmentblock = BottomSheetDialogBlock()
                        bottomSheetFragmentblock.mContext = requireContext()
                        bottomSheetFragmentblock.setOnCompleteListener(object :
                            BottomSheetDialogBlock.OnCompleteListener{
                            override fun OnCancelTap(pos: Int) {

                            }

                            override fun OnOptionTap(pos: Int) {

                            }

                        })
                        bottomSheetFragmentblock.show(requireActivity().supportFragmentManager, bottomSheetFragment.tag)
                    }

                else    if(pos ==5)
                    {
                        val bottomSheetFragmentclearchat = BottomSheetDialogClearChat()
                        bottomSheetFragmentclearchat.mContext = requireContext()
                        bottomSheetFragmentclearchat.setOnCompleteListener(object :BottomSheetDialogClearChat.OnCompleteListener{
                            override fun OnCancelTap(pos: Int) {

                            }

                            override fun OnOptionTap(pos: Int) {

                            }

                        })
                        bottomSheetFragmentclearchat.show(requireActivity().supportFragmentManager, bottomSheetFragment.tag)
                    }

                }


            })
        bottomSheetFragment.show(requireActivity().supportFragmentManager, bottomSheetFragment.tag)
    }

    private fun openGallery() {
        pickImageLauncher.launch("image/*")
    }



}