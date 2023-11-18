package com.advantal.myfamouschat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import androidx.navigation.fragment.findNavController
import com.advantal.myfamouschat.databinding.FragmentSplashBinding

import com.advantal.myfamouschat.utils.AppSession
import com.advantal.myfamouschat.utils.Helper
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
@AndroidEntryPoint
/**
 * Splash activity
 *
 * @constructor Create empty Splash activity
 */
class SplashActivity : AppCompatActivity() {
    @Inject
    lateinit var appSession: AppSession
    var _binding: FragmentSplashBinding? = null
    private val binding get() = _binding!!
    /**
     * Called to create the View for the SplashFragment.
     *
     * This method inflates the layout and sets up any necessary UI components.
     *
     * @param inflater The LayoutInflater object that can be used to inflate any views in the Fragment.
     * @param container The parent view that the Fragment UI should be attached to.
     * @param savedInstanceState A Bundle containing the saved state of the Fragment.
     * @return The root View of the Fragment UI.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = FragmentSplashBinding.inflate(layoutInflater)
        setContentView(_binding!!.root)
        Helper.transparentStatusBarbothtransandfull(this ,true ,true ,3)
    }

    /**
     * Navigate to OnBoarding
     *
     */
    private fun navigateNormal() {
        val intent = Intent(this, MainActivity::class.java)
        intent.flags = (Intent.FLAG_ACTIVITY_CLEAR_TASK or
                Intent.FLAG_ACTIVITY_NEW_TASK or
                Intent.FLAG_ACTIVITY_NEW_TASK
                or Intent.FLAG_ACTIVITY_CLEAR_TOP)

        startActivity(intent)
        finish()
    }

    override fun onStart() {

        /**
         * Timer for splash countdown
         *
         */
        object : CountDownTimer(3000 ,100){
            override fun onTick(p0: Long) {
            }
            override fun onFinish() {
                /**
                 * Checking if User has logged in or not
                 *
                 */
                if(appSession.isUserLoggedIn)
                {
                    navigateToPostOnBoarding()
                }else{
                    /**
                     * Navigate to Login Screen
                     *
                     */
                    navigateNormal()
                }
//                navigateNormal()

            }

        }.start()
        super.onStart()
    }
    /**
     * Navigate User To Post On Boarding
     *
     */
    private fun navigateToPostOnBoarding() {
        val intent = Intent(this, MainActivity::class.java)
        intent.flags = (Intent.FLAG_ACTIVITY_CLEAR_TASK or
                Intent.FLAG_ACTIVITY_NEW_TASK or
                Intent.FLAG_ACTIVITY_NEW_TASK
                or Intent.FLAG_ACTIVITY_CLEAR_TOP)

        startActivity(intent)
        finish()
    }

    /**
     * onDestroy will make _binding to null to release the memory
     */
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}