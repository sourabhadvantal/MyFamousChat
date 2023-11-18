package com.advantal.myfamouschat.utils

import android.app.Activity
import android.content.Context
import android.content.res.Configuration
import android.graphics.Color
import android.location.Address
import android.location.Geocoder
import android.os.Build
import android.text.Selection
import android.text.Spannable
import android.text.SpannableString
import android.text.Spanned
import android.text.TextPaint
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.util.Log
import android.view.View
import android.view.WindowManager
import android.widget.TextView
import androidx.appcompat.app.AppCompatDelegate

import com.advantal.myfamouschat.R
import com.google.android.material.color.DynamicColors
import java.text.SimpleDateFormat
import java.util.Locale

object Helper {
    fun convertAnyDateFormatToISODateFormat(dateString: String): String {
//        val formatter = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//            DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
//        } else {
//            TODO("VERSION.SDK_INT < O")
//        }
//        val localDateTime = LocalDate.parse(dateString, DateTimeFormatter.ofPattern("dd MMMM yyyy"))
//        return formatter.format(localDateTime)
        // Define the input format
        val inputFormat = SimpleDateFormat("dd MMMM yyyy", Locale.ENGLISH)

        // Parse the input string to a Date object
        val date = inputFormat.parse(dateString)

        // Define the desired output format
        val outputFormat = SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH)
//        val outputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.ENGLISH)

        // Set the timezone to UTC (optional, but recommended for ISO 8601 dates)
//        outputFormat.timeZone = TimeZone.getTimeZone("UTC")

        // Format the Date object to the ISO 8601 format
        val iso8601DateString = outputFormat.format(date)
        return  iso8601DateString

    }
    fun convertISODateFormatToDateFormat(inputDateString: String, outputFormat: String, locale: Locale = Locale.getDefault()): String {
        val inputFormat = SimpleDateFormat("dd-MM-yyyy", locale)
        val outputDate = inputFormat.parse(inputDateString)
        val outputSimpleDateFormat = SimpleDateFormat(outputFormat, locale)
        return outputSimpleDateFormat.format(outputDate)

    }
    fun convertISODateFormatToSlashDateFormat(inputDateString: String, outputFormat: String, locale: Locale = Locale.getDefault()): String {
        val inputFormat = SimpleDateFormat("dd-MM-yyyy", locale)
        val outputDate = inputFormat.parse(inputDateString)
        val outputSimpleDateFormat = SimpleDateFormat(outputFormat, locale)
        return outputSimpleDateFormat.format(outputDate)

    }
    private var defaultStatusBarColor: Int = R.color.black
    /**
     * Make links
     *
     * @param links
     * @param textView
     * TODO will be used
     */
    fun makeLinks(vararg links: Pair<String, View.OnClickListener>, textView: TextView) {
        val spannableString = SpannableString(textView.text)
        var startIndexOfLink = -1
        for (link in links) {
            val clickableSpan = object : ClickableSpan() {
                override fun updateDrawState(textPaint: TextPaint) {
                    // use this to change the link color
                    textPaint.color = textPaint.linkColor
                    // toggle below value to enable/disable
                    // the underline shown below the clickable text
                    textPaint.isUnderlineText = true
                }

                override fun onClick(view: View) {
                    Selection.setSelection((view as TextView).text as Spannable, 0)
                    view.invalidate()
                    link.second.onClick(view)
                }
            }
            startIndexOfLink = textView.text.toString().indexOf(link.first, startIndexOfLink + 1)
            spannableString.setSpan(
                clickableSpan, startIndexOfLink, startIndexOfLink + link.first.length,
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
            )
        }
        textView.movementMethod =
            LinkMovementMethod.getInstance() // without LinkMovementMethod, link can not click
        textView.setText(spannableString, TextView.BufferType.SPANNABLE)
    }



    open fun transparentStatusBar(
        activity: Activity,
        isTransparent: Boolean,
        fullscreen: Boolean,
        destination_place: Int
    ) {
//        requireActivity().window.navigationBarColor = SurfaceColors.SURFACE_2.getColor(requireActivity().applicationContext);
        when (destination_place) {
            0 -> {
                DynamicColors.applyToActivityIfAvailable(activity) // After this
                activity.window.navigationBarColor = Color.parseColor("#252525")
            }
            3 -> {
                DynamicColors.applyToActivityIfAvailable(activity) // After this
                activity.window.navigationBarColor = activity.resources.getColor(R.color.transparent)
            }
            else -> {
                DynamicColors.applyToActivityIfAvailable(activity) // After this
                activity.window.navigationBarColor = activity.resources.getColor(R.color.background_color)
            }
        }

        if (isTransparent) {
            activity.window.decorView.systemUiVisibility =
                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
//            (Objects.requireNonNull(requireActivity()) as AppCompatActivity).supportActionBar!!.hide()
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                defaultStatusBarColor = activity.window.statusBarColor
                activity.window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
                activity.window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
                // FOR TRANSPARENT NAVIGATION BAR
                //activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
                activity.window.statusBarColor = Color.TRANSPARENT
                Log.d(
                    activity.javaClass.simpleName,
                    "Setting Color Transparent " + Color.TRANSPARENT + " Default Color " + defaultStatusBarColor
                )
            } else {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                    Log.d(activity.javaClass.simpleName, "Setting Color Trans " + Color.TRANSPARENT)
                    activity.window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
                }
            }
        } else {
            if (fullscreen) {
                val decorView = activity.window.decorView
                val uiOptions = (View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        or View.SYSTEM_UI_FLAG_FULLSCREEN)
                decorView.systemUiVisibility = uiOptions
            } else {
//                (Objects.requireNonNull(requireActivity()) as AppCompatActivity).supportActionBar!!.show()
                activity.window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_VISIBLE
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    activity.window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION)
                    activity.window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
                    activity.window.clearFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
                    activity.window.clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
                    activity.window.statusBarColor = activity.resources.getColor(R.color.black)
                } else {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                        activity.window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
                    }
                }
            }
        }

    }

    open fun transparentStatusBarbothtransandfull(activity: Activity, isTransparent: Boolean, fullscreen: Boolean, destination_place: Int) {
//        requireActivity().window.navigationBarColor = SurfaceColors.SURFACE_2.getColor(requireActivity().applicationContext);
        when (destination_place) {
            0 -> {
                DynamicColors.applyToActivityIfAvailable(activity) // After this
                activity.window.navigationBarColor = Color.parseColor("#252525")
            }
            3 -> {
                DynamicColors.applyToActivityIfAvailable(activity) // After this
                activity.window.navigationBarColor = activity.resources.getColor(R.color.transparent)
            }
            2 -> {
                DynamicColors.applyToActivityIfAvailable(activity) // After this
                activity.window.navigationBarColor = activity.resources.getColor(R.color.black)
            }
            5 -> {
                DynamicColors.applyToActivityIfAvailable(activity) // After this
                activity.window.navigationBarColor = activity.resources.getColor(R.color.white)
            }
            else -> {
                DynamicColors.applyToActivityIfAvailable(activity) // After this
                activity.window.navigationBarColor = activity.resources.getColor(R.color.background_color)
            }
        }
        if (isTransparent) {
            activity.window.decorView.systemUiVisibility =
                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
//            (Objects.requireNonNull(requireActivity()) as AppCompatActivity).supportActionBar!!.hide()
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                defaultStatusBarColor = activity.window.statusBarColor
                activity.window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
                activity.window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
                // FOR TRANSPARENT NAVIGATION BAR
                //activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
                activity.window.statusBarColor = Color.TRANSPARENT
                Log.d(
                    activity.javaClass.simpleName,
                    "Setting Color Transparent " + Color.TRANSPARENT + " Default Color " + defaultStatusBarColor
                )
            } else {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                    Log.d(activity.javaClass.simpleName, "Setting Color Trans " + Color.TRANSPARENT)
                    activity.window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
                }
            }
        }
        else {
            if (fullscreen) {
                val decorView = activity.window.decorView
                val uiOptions = (View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        or View.SYSTEM_UI_FLAG_FULLSCREEN)
                decorView.systemUiVisibility = uiOptions
            } else {

                activity.window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_VISIBLE
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    activity.window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION)
                    activity.window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
                    activity.window.clearFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
                    activity.window.clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
                    activity.window.statusBarColor = activity.resources.getColor(R.color.black)
                } else {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                        activity.window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
                    }
                }
            }
        }


    }


    fun convertStatusBar(activity: Activity, isTransparent: Boolean, fullscreen: Boolean, destination_place: Int, type: Int
    ){
        when (destination_place) {
            0 -> {
                DynamicColors.applyToActivityIfAvailable(activity) // After this
                activity.window.navigationBarColor = Color.parseColor("#252525")
            }
            3 -> {
                DynamicColors.applyToActivityIfAvailable(activity) // After this
                activity.window.navigationBarColor = activity.resources.getColor(R.color.transparent)
            }
            5 -> {
                DynamicColors.applyToActivityIfAvailable(activity) // After this
                activity.window.navigationBarColor = activity.resources.getColor(R.color.white)
            }
            else -> {
                DynamicColors.applyToActivityIfAvailable(activity) // After this
                activity.window.navigationBarColor = activity.resources.getColor(R.color.background_color)
            }
        }
        if (isTransparent) {
            activity.window.decorView.systemUiVisibility =
                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
//            (Objects.requireNonNull(requireActivity()) as AppCompatActivity).supportActionBar!!.hide()
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                defaultStatusBarColor = activity.window.statusBarColor
                activity.window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
                activity.window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
                // FOR TRANSPARENT NAVIGATION BAR
                //activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
                activity.window.statusBarColor = Color.TRANSPARENT
                Log.d(activity.javaClass.simpleName, "Setting Color Transparent " + Color.TRANSPARENT + " Default Color " + defaultStatusBarColor)
            } else {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                    Log.d(activity.javaClass.simpleName, "Setting Color Trans " + Color.TRANSPARENT)
                    activity.window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
                }
            }
        }
        else {
            if (fullscreen) {
                val decorView = activity.window.decorView
                val uiOptions = (View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        or View.SYSTEM_UI_FLAG_FULLSCREEN)
                decorView.systemUiVisibility = uiOptions
            } else {
                if(type ==1)
                {
                    activity.window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_VISIBLE
                }

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    activity.window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION)
                    activity.window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
                    activity.window.clearFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
                    activity.window.clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
                    if(type ==1)
                    {
                        activity.window.statusBarColor = activity.resources.getColor(R.color.black)
                    }

                } else {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                        activity.window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
                    }
                }
            }
        }
    }
    fun convertStatusBarAndBottomBarWithColor(activity: Activity
                                              , statusbarcolor : Int, navigationbarcolor : Int){

                DynamicColors.applyToActivityIfAvailable(activity) // After this
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if(navigationbarcolor !=-1)
            {
                activity.window.navigationBarColor = activity.resources.getColor(navigationbarcolor , null)
            }
            if(statusbarcolor !=-1)
            {
                activity.window.statusBarColor =  activity.resources.getColor(statusbarcolor , null)
            }


        }



    }
    fun onlyFullScreen(activity: Activity, type: Int) {
        if(type ==0)
        {
            // Make the status bar transparent
            activity. getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        }

        // Hide the bottom navigation bar
        activity. getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
    }


}