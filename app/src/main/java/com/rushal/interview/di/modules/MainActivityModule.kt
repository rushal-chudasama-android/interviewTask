package com.rushal.interview.di.modules


import dagger.Module
import dagger.android.ContributesAndroidInjector
import com.rushal.interview.presentation.MainActivity

@Suppress("unused")
@Module
abstract class MainActivityModule {
    @ContributesAndroidInjector(
        modules = [
            FragmentBuildersModule::class
        ]
    )
    abstract fun contributeMainActivity(): MainActivity
}
