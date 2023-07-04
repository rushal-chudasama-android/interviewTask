package com.rushal.interview.api

import com.rushal.interview.data.model.ImagesResponse
import retrofit2.http.GET

/**
 * created by Ronnie Otieno on 31-Mar-21.
 */
interface UnSplashService {
    @GET("photos")
    suspend fun getImages(): List<ImagesResponse>
}