package com.rushal.interview.di.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.MapKey
import dagger.Module
import dagger.multibindings.IntoMap
import com.rushal.interview.presentation.viewmodels.ImagesListViewModel
import com.rushal.interview.presentation.viewmodels.SingleImageViewModel
import com.rushal.interview.presentation.viewmodels.ViewModelFactory
import kotlin.reflect.KClass

@Suppress("unused")
@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(ImagesListViewModel::class)
    abstract fun bindImagesListViewModel(imagesListViewModel: ImagesListViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SingleImageViewModel::class)
    abstract fun bindSingleImageViewModel(singleImageViewModel: SingleImageViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}

@MustBeDocumented
@Target(
    AnnotationTarget.FUNCTION,
    AnnotationTarget.PROPERTY_GETTER,
    AnnotationTarget.PROPERTY_SETTER
)
@Retention(AnnotationRetention.RUNTIME)
@MapKey
annotation class ViewModelKey(val value: KClass<out ViewModel>)
