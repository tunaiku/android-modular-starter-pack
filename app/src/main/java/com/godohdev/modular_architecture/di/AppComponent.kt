package com.godohdev.modular_architecture.di

import android.app.Application
import com.godohdev.modular_architecture.MainApplication
import com.godohdev.networkmodule.di.NetworkModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton


/**
 *
 * Created by Wahyu Permadi on 2019-12-13.
 * Android Engineer
 *
 **/

@Singleton
@Component(modules = [
    AndroidInjectionModule::class,
    NetworkModule::class
])
interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application) : Builder
        fun build() : AppComponent
    }

    fun inject(app: MainApplication)
}