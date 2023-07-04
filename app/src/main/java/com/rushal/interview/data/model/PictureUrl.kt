package com.rushal.interview.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * created by Ronnie Otieno on 31-Mar-21.
 */
@Parcelize
data class PictureUrl(var regular: String, var full: String) : Parcelable