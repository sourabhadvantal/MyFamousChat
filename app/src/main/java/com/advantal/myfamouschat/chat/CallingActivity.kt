package com.advantal.myfamouschat.chat

import androidx.appcompat.app.AppCompatActivity
import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.annotation.RequiresApi
import com.advantal.myfamouschat.R
import com.advantal.myfamouschat.databinding.ActivityCallingBinding
import com.advantal.myfamouschat.utils.AppConstant


/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
class CallingActivity : AppCompatActivity() {

    /**
     * Binding
     */
    private lateinit var binding: ActivityCallingBinding


    /**
     * On create
     *
     * @param savedInstanceState
     */
    @RequiresApi(Build.VERSION_CODES.M)
    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityCallingBinding.inflate(layoutInflater)
        var bundle :Bundle ?=intent.extras

        if (bundle != null) {
            if (bundle.containsKey(AppConstant.CALL_POSITION)) {
                var message = bundle!!.getInt(AppConstant.CALL_POSITION) // 1
                if(message ==0)
                {
                    binding.flVideocall.visibility =View.GONE
                    binding.flNormalcall.visibility =View.VISIBLE
                    binding.liVideoCallOption.visibility = View.GONE
                    binding.liNameVideoInfor.visibility = View.GONE
//                    binding.backBtn.visibility =View.VISIBLE
                }else{
                    binding.flVideocall.visibility =View.VISIBLE
                    binding.liVideoCallOption.visibility = View.VISIBLE
                    binding.flNormalcall.visibility =View.GONE
                    binding.liNameVideoInfor.visibility = View.VISIBLE
//                    binding.tvCallerName.setTextColor(resources.getColor(R.color.white , null))
//                    binding.tvCallerDuration.setTextColor(resources.getColor(R.color.white , null))
                }
            }
        }

        window.statusBarColor = resources.getColor(R.color.black)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_VISIBLE
        window.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
        initUIs();
        setContentView(binding.root)




    }

    private fun initUIs() {
        binding!!.liHungUpAudooCall.setOnClickListener {
            finish()
        }

        binding!!.liHungUpCall.setOnClickListener {
            finish()
        }


    }


    /**
     * On destroy
     *
     */
    override fun onDestroy() {

//        window.statusBarColor = resources.getColor(R.color.black)
//        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        window.clearFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        super.onDestroy()
    }




}