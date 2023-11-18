package com.advantal.myfamouschat.chat

import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import com.advantal.myfamouschat.R
import com.advantal.myfamouschat.databinding.FragmentCallBinding

//import com.advantal.myfamous.databinding.FragmentCallActivityBinding

import com.advantal.myfamouschat.helpers.BaseFragment
import com.advantal.myfamouschat.utils.AppConstant
import com.advantal.myfamouschat.utils.Helper


/**
 * Call activity fragment
 *
 * @constructor Create empty Call activity fragment
 */
class CallFragment : BaseFragment() {
    private var sendbundle: Bundle?=null
    var _binding : FragmentCallBinding?=null

    val binding get() = _binding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        initializeNavigation(requireActivity())
        // Inflate the layout for this fragment
        _binding = FragmentCallBinding.inflate(layoutInflater)
        binding!!.rlPickCall.setOnClickListener {
        navigateToScreen(R.id.action_nav_fragment_call_initial_to_nav_activity_calling ,sendbundle)
        }
        binding!!.rlCancelCall.setOnClickListener {
            onBackButtonClick()
        }

        return  _binding!!.root
    }

    override fun onStart() {
        val bundle = arguments
        if (bundle != null) {
            if (bundle.containsKey(AppConstant.CALL_POSITION)) {
                Log.e("bundle" ,""+bundle.getInt(AppConstant.CALL_POSITION))
                sendbundle = bundle
            }
        }
        super.onStart()
        Helper.transparentStatusBarbothtransandfull(requireActivity(), true, true, 2);
    }


    /**
     * On stop
     *
     */
    override fun onStop() {
        super.onStop()
        Helper.transparentStatusBarbothtransandfull(requireActivity(), true, true, 3);
    }

    /**
     * On destroy view
     *
     */
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
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
    }
}