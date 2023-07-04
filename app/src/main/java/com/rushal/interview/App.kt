package com.rushal.interview

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import com.rushal.interview.di.DaggerAppComponent

class App : DaggerApplication() {
    private val applicationInjector = DaggerAppComponent.builder().application(this).build()
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> = applicationInjector
}
