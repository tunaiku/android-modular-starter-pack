package com.godohdev.common.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable


/**
 *
 * Created by Wahyu Permadi on 2019-12-17.
 * Android Engineer
 *
 **/

abstract class BaseViewModel : ViewModel(){
    var compositeDisposable = CompositeDisposable()

    protected val _loadingHandler = MutableLiveData<Boolean>()
    val loadingHandler: LiveData<Boolean> get() = _loadingHandler
}