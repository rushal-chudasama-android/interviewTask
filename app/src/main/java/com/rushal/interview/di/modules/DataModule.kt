package com.rushal.interview.di.modules

import dagger.Module
import dagger.Provides
import com.rushal.interview.api.UnSplashService
import com.rushal.interview.data.repository.Repository
import javax.inject.Singleton


/**
 *created by Ronnie Otieno on 03-Apr-21.
 **/
@Module
object DataModule {

    @Singleton
    @Provides
    fun providesRepository(unSplashService: UnSplashService): Repository =
        Repository(unSplashService)
}