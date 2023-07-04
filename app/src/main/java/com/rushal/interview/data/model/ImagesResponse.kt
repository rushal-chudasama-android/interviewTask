package com.rushal.interview.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * created by Ronnie Otieno on 31-Mar-21.
 */

@Parcelize
data class ImagesResponse(
    var id: Int,
    var albumId: Int,
        var title: String,
    var thumbnailUrl: String,
    var url: String,
) : Parcelable
