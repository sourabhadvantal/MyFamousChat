package com.advantal.myfamouschat.di


/**
 * Api interface
 *
 * @constructor Create empty Api interface
 * Will be used for API calling
 */
interface ApiInterface {
    companion object {
        const val HEADER_VALUE = "Accept: application/json"
        const val HEADER_CONTENT_TYPE = "Content-type: application/json"
        const val AUTHORIZATION = "auth/Authorization"
        const val WS_LOGIN = "auth/login"
        const val WS_SIGNUP = "auth/signUp"
        const val WS_FORGOT_PASSWORD = "auth/forgotPassword"
        const val WS_CHANGE_PASSWORD = "auth/changePassword"
        const val WS_GET_TERMS_AND_CONDITION = "admin/termsAndCondition/getTermsAndCondition/userType"

        //   const val WS_GET_TERMS_AND_CONDITION= "admin/termsAndCondition/getTermsAndCondition/userType"
        const val WS_GET_ALL_PRIVACY_POLICY = "admin/privacyPolicy/getAllPrivacyPolicy"
        const val WS_GET_ALL_BLACK_BOX = "admin/blackBox/getAllPublishedBlackBox"
//        const val WS_GET_ALL_BLACK_BOX = "admin/blackBox/getAllBlackBox"
        const val WS_GET_ALL_BLACK_BOX_DRAFT = "admin/blackBox/getAllDraftBlackBox"
        const val WS_CREATE_BRAND_USER = "user/brandUser/createBrandUser"
        const val WS_CHECK_PROFILE_FRIEND_OR_NOT = "user/socialFollow/checkProfileFriendOrNot"
        const val WS_ADD_SOCIAL_FOLLOW = "user/socialFollow/addSocialFollow"
        const val WS_CREATE_PICKUP_USER = "user/pickupUser/createPickupUser"
        const val WS_CREATE_FAMOUS_USER = "http://151.106.39.5:5004/api/v1/user/famousUser/createFamousUser"
        const val WS_CREATE_BLACK_BOX = "admin/blackBox/createBlackBox"
        const val WS_DELETE_BLACK_BOX = "admin/blackBox/delete_black_box"
        //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        const val WS_GET_COUNTRY = "user/address/getCountry"
        const val WS_GET_STATES_BY_COUNTRY_ID = "user/address/getStatesByCountryId"
        const val WS_GET_CITY_BY_STATE_ID = "user/address/getCityByStateId"
        //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        const val WS_EDIT_PROFILE = "http://151.106.39.5:5002/api/v1/auth/editProfile"
        const val WS_GET_USER_PROFILE_BY_ID = "http://151.106.39.5:5002/api/v1/auth/getUserProfileById/"
        const val WS_VERIFY_ACTIVATION_CODE = "auth/verifyActivationCode"
        const val WS_GET_ALL_USER_BY_SEARCH = "http://151.106.39.5:5002/api/v1/auth/getAllUserBySearch"
        const val WS_GET_ALL_BRAND_CITY = "http://151.106.39.5:5005/api/v1/brand/store/getAllNormalBrandStoreByCity"
        const val WS_FOLLOWERS_BY_USER_ID = "http://151.106.39.5:5004/api/v1/user/socialFollow/getAllFollowersByUserId"
        const val WS_ALL_FAMOUS_BY_USER_ID = "http://151.106.39.5:5004/api/v1/user/socialFollow/getAllFamousFollowingByUserId"
        const val WS_FOLLOWING_BY_USER_ID = "http://151.106.39.5:5004/api/v1/user/socialFollow/getAllFollowingByUserId"
        const val WS_REQUEST_LIST_USER_ID = "http://151.106.39.5:5004/api/v1/user/socialFollow/getRequestListByUserId"
        const val WS_REQUEST_ACCEPT_REJECT = "http://151.106.39.5:5004/api/v1/user/socialFollow/requestAcceptOrRejectFromUserId"
        const val WS_REQUEST_UNFRIEND_USER = "http://151.106.39.5:5004/api/v1/user/socialFollow/unfriendUser"
        const val WS_ACCOUNT_PRIVACY = "http://151.106.39.5:5002/api/v1/auth/account_privacy"
        const val WS_GET_FAMOUS_BRAND_COUNTRY = "http://151.106.39.5:5005/api/v1/brand/store/getAllFamousBrandStoreByCountry"
        const val WS_GET_SMALL_TYPE_PRODUCT_LIST = "http://151.106.39.5:5005/api/v1/brand/dashboard/getSmallTypeProductList"
        const val WS_GET_LARGE_TYPE_PRODUCT_LIST = "http://151.106.39.5:5005/api/v1/brand/dashboard/getLargeTypeProductList"
        const val WS_GET_BRAND_DASHBOARD_STORE_ID = "http://151.106.39.5:5005/api/v1/brand/dashboard/getBrandDashboardByStoreId"
        const val WS_GET_ALL_PRODUCT_STORE_SEARCH = "http://151.106.39.5:5005/api/v1/brand/dashboard/getAllProductByStoreId"
        const val WS_GET_SEE_ALL_PRODUCT = "http://151.106.39.5:5005/api/v1/brand/dashboard/seeAllProductList"

    }

}