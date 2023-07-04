package com.rushal.interview.presentation.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.rushal.interview.data.repository.Repository
import javax.inject.Inject


/**
 *created by Ronnie Otieno on 03-Apr-21.
 **/

@Suppress("deprecation", "BlockingMethodInNonBlockingContext")
class SingleImageViewModel @Inject constructor(
    private val app: Application,
    private val repo: Repository
) :
    AndroidViewModel(app) {
    var imageString: String? = null
    val shouldRound = false

    private val _notifyDownloading = MutableLiveData<Int>()
}