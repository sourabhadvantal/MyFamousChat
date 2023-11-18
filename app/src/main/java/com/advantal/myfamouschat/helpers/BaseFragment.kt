package com.advantal.myfamouschat.helpers

import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.content.res.Resources
import android.database.Cursor
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.util.TypedValue
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation

import com.advantal.myfamouschat.R
import java.io.File


/**
 * Base fragment
 *
 * @constructor Create empty Base fragment
 */
open class BaseFragment : Fragment() {

    public var navController: NavController? = null


    /**
     * Navigate to screen
     *
     * @param actionNav
     * @param bundle
     */
    fun navigateToScreen(actionNav: Int, bundle: Bundle?) {
        navController!!.navigate(actionNav, bundle)
    }


    /**
     * initializeNavigation
     *
     * @param requireActivity
     */
    fun initializeNavigation(requireActivity: FragmentActivity) {
        navController = Navigation.findNavController(requireActivity, R.id.nav_home_host_fragment)
//        val nightModeFlags = requireContext().resources.configuration.uiMode and
//                Configuration.UI_MODE_NIGHT_MASK
//
//        when (nightModeFlags) {
//            Configuration.UI_MODE_NIGHT_YES -> {
//                DynamicColors.applyToActivityIfAvailable(requireActivity()) // After this
//                activity?.window?.navigationBarColor = Color.parseColor("#252525")}
//            Configuration.UI_MODE_NIGHT_NO -> {}
//            Configuration.UI_MODE_NIGHT_UNDEFINED -> {}
//        }
    }











    /**
     * On back button click
     *
     */
    open fun onBackButtonClick() {
        requireActivity().onBackPressed()
    }



    /**
     * On pops
     *
     * @param root
     */
    open fun onPops(root: Int) {
       Log.d("Pops" , ""+root)
        navController?.popBackStack(root, true)

    }




    /**
     * Check null validation
     *  this method will check if the field is empty or not
     * @param value
     * @return
     */
    open fun checkNullValidation(value : String ): Boolean {
      return  value.isEmpty()
    }


   open fun checkEmailValidation(value : String ): Boolean {
       val EMAIL_REGEX_PATTERN = Regex("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")
       return !EMAIL_REGEX_PATTERN.matches(value)

    }




    fun hideKeyBoard( view : View){
        val imm = requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager?
        imm!!.hideSoftInputFromWindow(view.windowToken, 0)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    fun dpToPix(requireActivity: Activity ,dip : Float): Float {

        val r: Resources = resources
        val px = TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            dip,
            r.getDisplayMetrics()
        )
        return px;
    }
}

