package com.rushal.interview.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.rushal.interview.api.UnSplashService
import com.rushal.interview.data.datasource.ImagesDataSource
import com.rushal.interview.utils.LOAD_SIZE
import javax.inject.Inject

/**
 *created by Ronnie Otieno on 03-Apr-21.
 **/
class Repository @Inject constructor(private val unSplashService: UnSplashService) {

    fun getImages() = Pager(
        config = PagingConfig(enablePlaceholders = false, pageSize = LOAD_SIZE),
        pagingSourceFactory = {
            ImagesDataSource(unSplashService)
        }
    ).flow
}