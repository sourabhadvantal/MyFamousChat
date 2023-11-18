package com.advantal.myfamouschat.utils

import android.Manifest
import android.os.Build

/**
 * App constant
 *
 * @constructor Create empty App constant
 */
class AppConstant {

    companion object{
        const val SEE_ALL_TYPE: String = "seealltype"
        const val SEE_PRODUCT_TITLE: String = "seeproducttitle"
        const  val APIKEY: String = "AIzaSyDW3dxC_aRqaUf511e533AjnQUL0X-zT2Q"

        //+++++++++++++++++++++++++++++Permissions++++++++++++++++++++++++++++++
        val PERMISSIONS_REQUIRED = arrayOf<String>(Manifest.permission.READ_EXTERNAL_STORAGE)
//        val PERMISSIONS_REQUIRED = arrayOf<String>(Manifest.permission.READ_MEDIA_IMAGES)
        val CAMERA_PERMISSIONS_REQUIRED = arrayOf<String>(Manifest.permission.CAMERA)
        val LOCATION_PERMISSIONS_REQUIRED = arrayOf<String>(Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.ACCESS_COARSE_LOCATION)
        val LOCATION_PERMISSIONS_BACKGROUND_REQUIRED = arrayOf<String>(Manifest.permission.ACCESS_BACKGROUND_LOCATION)

//        val MEDIA_PERMISSIONS_REQUIRED = arrayOf<String>(Manifest.permission.CAMERA ,Manifest.permission.READ_MEDIA_IMAGES,Manifest.permission.READ_MEDIA_VIDEO)
        val MEDIA_PERMISSIONS_REQUIRED = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            arrayOf<String>(Manifest.permission.CAMERA ,Manifest.permission.READ_MEDIA_IMAGES,Manifest.permission.READ_MEDIA_VIDEO)
        } else {
            arrayOf<String>(Manifest.permission.CAMERA ,Manifest.permission.READ_EXTERNAL_STORAGE)
        }
        const val QUERY_PAGE_SIZE = 10

        val mobileNumberPrefixes = listOf(
            "+91", // India
            "+1", // United States
            "+86", // China
            "+44", // United Kingdom
            "+7", // Russia
            "+55", // Brazil
            "+62", // Indonesia
            "+92", // Pakistan
            "+81", // Japan
            "+234", // Nigeria
            "+972", // Israel
            "+65", // Singapore
            "+971", // United Arab Emirates
            "+43", // Austria
            "+32", // Belgium
            "+591", // Bolivia
            "+55", // Brazil
            "+359", // Bulgaria
            "+855", // Cambodia
            "+1", // Canada
            "+56", // Chile
            "+86", // China
            "+57", // Colombia
            "+385", // Croatia
            "+599", // Curaçao
            "+420", // Czech Republic
            "+45", // Denmark
            "+1", // Dominica
            "+1", // Dominican Republic
            "+593", // Ecuador
            "+375", // Belarus
            "+33", // France
            "+49", // Germany
            "+30", // Greece
            "+502", // Guatemala
            "+504", // Honduras
            "+852", // Hong Kong
            "+36", // Hungary
            "+91", // India
            "+62", // Indonesia
            "+353", // Ireland
            "+972", // Israel
            "+39", // Italy
            "+81", // Japan
            "+966", // Saudi Arabia
            "+65", // Singapore
            "+34", // Spain
            "+46", // Sweden
            "+41", // Switzerland
            "+886", // Taiwan
            "+66", // Thailand
            "+90", // Turkey
            "+256", // Uganda
            "+44", // United Kingdom
            "+1", // United States
            "+598", // Uruguay
            "+84", // Vietnam
        )
        //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        const val USER_BLACK_BOX_RESPONSE: String = "user_black_box_response"
        const val USER_LOCATION: String = "user_location"
        const val USER_REM_TYPE: String = "user_rem_type"
        const val DEVICE_TYPE: String = "Android"
        const val STORY_POSITION: String = "story_position"
        const val HOME: String = "home"
        const val CAMERA_MODULE: String = "cameramodule"
        const val NOTIFICATION_TOGGLE_YPE: String = "notification_toggle_type"
        const val NORMAL: String = "Normal"
        const val MY_FAMOUS_USER: String = "MyFamous User"
        const val MY_FAMOUS_PICKUP_USER: String = "MyFamous PickUp User"
        const val MY_BRAND: String = "MyBrand"
        const val USER_TYPE: String = "usertype"
        const val USER_DATA: String = "userdata"
        const val USER_PROFILE_DATA: String = "profileuserdata"
//        const val IsUserLoggedIn: String = "isuserloggedin"
        const val CALL_POSITION: String = "callpos"
        const val CAMERA_PLACE: String = "camera_place"
        const val IMAGE_NAVIGATION: String = "image_navigation"
        const val ImageUrl: String = "image_url"
        const val PICK_IMAGE_REQUEST = 1

        const val DARK_THEME = "dark"
        const val LIGHT_THEME = "light"
        const val ARABIC = "ar"
        const val KEY_STORY_DATA = "KEY_STORY_DATA"
        const val KEY_STORIES_LIST_DATA = "KEY_STORY_DATA"
        //+++++++++++++++++++++++++++++APi calls Params++++++++++++++++++++++
        //++++++++++++++++++++++Login+++++++++++++++++++
        const val DEVICE = "Android"
        const val PN_EMAIL_OR_USER_NAME = "emailOrUsername"
        const val PN_PASSWORD = "password"
        const val PN_DEVICE_TOKEN = "deviceToken"
        const val PN_DEVICE_TYPE = "deviceType"
        //+++++++++++++++++++++++++Registration++++++++++++++++
        const val PN_NAME: String = "name"
        const val PN_EMAIL: String = "email"
        const  val PN_USERNAME: String = "username"
        const  val PN_MY_FAMOUS_CODE: String = "myFamousCode"
        //++++++++++++++++++++++++++Change Password+++++++++++++++++++
        const val PN_ID: String = "id"
        const val PN_OLD_PASSWORD: String = "oldPassword"
        const  val PN_NEW_PASSWORD: String = "newPassword"
        //+++++++++++++++++++++++Forgot password+++++++++
        const  val PN_USER_TYPE: String = "userType"
        //++++++++++++Brand User Registration++++++++++++++++++++
        const  val PN_MOBILE_NUMBER: String = "mobileNumber"
        const  val PN_BUSINESS_NAME: String = "businessName"
        const  val PN_CATEGORY: String = "category"
        const  val PN_POSTAL_CODE: String = "postalCode"
        const  val PN_COUNTRY: String = "country"
        const  val PN_STATE: String = "state"
        const  val PN_CITY: String = "city"
        const  val PN_ADDRESS: String = "address"
        const  val PN_LANDMARK: String = "landmark"
        const  val PN_TYPE_OF_ESTABLISHMENT: String = "typeOfEstablishment"
        const  val PN_NO_OF_ESTABLISHMENT: String = "noOfEstablishment"
        const  val PN_DOCUMENT_TYPE: String = "documentType"
        const  val PN_DOCUMENT_FILE_LIST: String = "documentFileList"
        const  val PN_URL_LINKS: String = "urlLinks"

        //++++++++++++++++++++++++++Verification++++++++++++++++++++++
        const  val PN_USERID: String = "userId"
        const  val PN_ACTIVATION_CODE: String = "activationCode"
        //++++++++++++++++++++++++++Black Box++++++++++++++++++++++

        const  val PN_TITLE: String = "title"
        const  val PN_WISDOM: String = "wisdom"
        const  val PN_START_DATE: String = "startDate"
        const  val PN_END_DATE: String = "endDate"
        const  val PN_PRICE: String = "price"
        const  val PN_LOCATION_REQUEST_PAYLOAD_LIST: String = "locationRequestPayloadList"
        const  val PN_LONGITUDE: String = "longitude"
        const  val PN_LATITUDE: String = "latitude"
        const  val PN_PUBLISHED: String = "published"
        //+++++++++++++++++++++++EDIT profile++++++++++++++++++++++++++
        const  val PN_DATE_OF_BIRTH: String = "dateOfBirth"
        const  val PN_BIO: String = "bio"
        const  val PN_GENDER: String = "gender"
        const  val PN_SOCIAL_MEDIA_LINKS: String = "socialMediaLinks"
        const  val PN_IMAGE_FILE: String = "imageFile"
        const  val PN_LOG_IN_USER_ID: String = "loginUserId"
        const  val PN_PAGE_INDEX: String = "pageIndex"
        const  val PN_PAGE_SIZE: String = "pageSize"
        const  val PN_SEARCH_TEXT: String = "searchText"
        const  val PN_SOCIAL_MEDIA_LINK_LIST: String = "socialMediaLinksList"
        const  val PN_COUNTRY_CODE: String = "countryCode"
        //+++++++++++++++++++++++++++++++++++Search+++++++++++\
        const  val OTHER_USER_ID: String = "otherUserId"
        const  val OTHER_USER_DATA: String = "otherUserData"
        //+++++++++++++++++++++++++++++++++++++++++
        const  val FROM_USER_ID: String = "fromUserId"
        const  val TO_USER_ID: String = "toUserId"
        const  val PN_KEY: String = "key"
        const  val PN_FRIEND_ID: String = "friendId"
        const  val PN_FROM_OTHER_USER: String = "fromOtherUser"
        const  val PN_STATUS: String = "status"
        const  val PN_ACCOUNT_PRIVATE: String = "isAccountPrivate"
        const  val PN_STORE_ID: String = "storeId"
        const  val PN_BRAND_DASHBOARD_ID  = "brandDashBoardId"
        const  val PN_BRAND_DASHBOARD_TYPE  = "dashboardType"





    }
}