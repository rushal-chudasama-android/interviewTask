package com.rushal.interview.data.datasource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.rushal.interview.api.UnSplashService
import com.rushal.interview.data.model.ImagesResponse
import com.rushal.interview.utils.STARTING_PAGE
import java.io.IOException


/**
 *created by Ronnie Otieno on 04-Apr-21.
 **/
class ImagesDataSource(private val unSplashService: UnSplashService) :
    PagingSource<Int, ImagesResponse>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ImagesResponse> {
        val page = params.key ?: STARTING_PAGE

        return try {
            val data = unSplashService.getImages()
            LoadResult.Page(
                data = data,
                prevKey = if (page == STARTING_PAGE) null else page - 1,
                nextKey = if (data.isEmpty()) null else page + 1
            )

        } catch (throwable: Throwable) {
            var exception = throwable
            if (throwable is IOException) {
                exception = IOException("Please check internet connection")
            }
            LoadResult.Error(exception)
        }

    }

    override fun getRefreshKey(state: PagingState<Int, ImagesResponse>): Int? {

        return state.anchorPosition

    }

}