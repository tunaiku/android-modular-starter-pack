package com.godohdev.modular_architecture

import android.app.Application
import android.content.Context
import androidx.multidex.MultiDex
import com.godohdev.modular_architecture.di.AppComponent
import com.godohdev.modular_architecture.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject


/**
 *
 * Created by Wahyu Permadi on 2019-12-13.
 * Android Engineer
 *
 **/

class MainApplication : Application(), HasAndroidInjector{

    private val daggerComponent by lazy {
        DaggerAppComponent.builder()
            .application(this)
            .build()
    }

    companion object{
        lateinit var instance: MainApplication
    }

    @Inject
    lateinit var mActivityDispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    override fun androidInjector(): AndroidInjector<Any> {
        return mActivityDispatchingAndroidInjector
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

    override fun onCreate() {
        super.onCreate()

        instance = this
        daggerComponent.inject(this)
    }
}