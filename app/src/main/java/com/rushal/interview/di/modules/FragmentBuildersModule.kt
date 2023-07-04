package com.rushal.interview.di.modules


import dagger.Module
import dagger.android.ContributesAndroidInjector
import com.rushal.interview.presentation.fragments.ImagesListFragment
import com.rushal.interview.presentation.fragments.SingleImageFragment

@Suppress("unused")
@Module
abstract class FragmentBuildersModule {
    @ContributesAndroidInjector
    abstract fun contributeImagesListFragment(): ImagesListFragment

    @ContributesAndroidInjector
    abstract fun contributeSingleFragment(): SingleImageFragment

}
