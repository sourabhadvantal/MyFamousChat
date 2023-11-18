package com.advantal.myfamouschat.utils

import android.content.SharedPreferences
import android.util.Log
import androidx.core.content.edit

import com.google.gson.Gson
import javax.inject.Inject
import javax.inject.Singleton

/**
 * App session
 *
 * @property sharedPref
 * @constructor Create empty App session
 */
@Singleton
class AppSession @Inject constructor(private var sharedPref: SharedPreferences) {
    private var editor: SharedPreferences.Editor? = null

    init {
        try {
            editor = sharedPref.edit()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
    fun resetAppSession(){
        editor = sharedPref.edit()

        editor?.clear()
        editor?.commit()
        Log.e("AppSession" , "App session reset")
    }
    fun setRememberType(userRemType : Boolean,email : String , password: String){
        sharedPref.edit {
            putBoolean(AppConstant.USER_REM_TYPE, userRemType)
        }
        sharedPref.edit {
            putString(AppConstant.PN_EMAIL, email)
        }
        sharedPref.edit {
            putString(AppConstant.PN_PASSWORD, password)
        }

        Log.e("AppSession" , "App session reset")
    }

    companion object {
        private const val PREF_AUTHENTICATED = "authState"
    }

    //****************************************** For checking of theme will be used *****************************************

    var isTheme: String
        get() = sharedPref.getString("theme", AppConstant.DARK_THEME)!!
        set(isShow) {
            sharedPref.edit { putString("theme", isShow) }
        }

    var isLanguage: String
        get() = sharedPref.getString("language", AppConstant.ARABIC)!!
        set(isShow) {
            sharedPref.edit { putString("language", isShow) }
        }



    var userType: String
        get() = sharedPref.getString("usertype", AppConstant.USER_TYPE)!!
        set(isShow) {
            sharedPref.edit {
                putString("usertype", isShow)
            }
        }
    var userRem: Boolean
        get() = sharedPref.getBoolean(AppConstant.USER_REM_TYPE, false)!!
        set(isShow) {
            sharedPref.edit {
                putBoolean(AppConstant.USER_REM_TYPE, isShow)
            }
        }
    var userEmail: String
        get() = sharedPref.getString(AppConstant.PN_EMAIL, "")!!
        set(isShow) {
            sharedPref.edit {
                putString(AppConstant.PN_EMAIL, isShow)
            }
        }
    var userPassword: String
        get() = sharedPref.getString(AppConstant.PN_PASSWORD, "")!!
        set(isShow) {
            sharedPref.edit {
                putString(AppConstant.PN_PASSWORD, isShow)
            }
        }

    var isUserLoggedIn: Boolean
        get() = sharedPref.getBoolean("is_user_logged_in", false)
        set(isShow) {
            sharedPref.edit {
                putBoolean("is_user_logged_in", isShow)
            }
        }




}
