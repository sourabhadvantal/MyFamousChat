package com.advantal.myfamouschat.repository

import android.content.ContentUris
import android.database.Cursor
import android.net.Uri
import android.os.Build
import android.provider.MediaStore

import com.advantal.myfamous.data.*

import com.advantal.myfamouschat.di.ApiService
import com.advantal.myfamouschat.di.Resource
import com.advantal.myfamouschat.utils.AppSession

import com.google.gson.Gson
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.asRequestBody
import retrofit2.HttpException
import retrofit2.Response
import java.io.File
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Main repository
 *
 * @property apiService
 * @property appSession
 * @constructor Create empty Main repository
 */
@Singleton
class MainRepository @Inject constructor(
    private val apiService: ApiService,
    private val appSession: AppSession
) {


}