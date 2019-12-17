package com.godohdev.common.base

import android.app.ProgressDialog
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import dagger.android.support.AndroidSupportInjection


/**
 *
 * Created by Wahyu Permadi on 2019-12-17.
 * Android Engineer
 *
 **/

abstract class BaseFragment : Fragment() {

    private lateinit var viewModel: BaseViewModel
    private lateinit var dialog : ProgressDialog
    abstract fun getViewModel() : BaseViewModel

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupObserver(getViewModel())
        dialog = ProgressDialog(context)
        dialog.setMessage("Please wait... ")
        dialog.setCancelable(false)
        dialog.dismiss()
    }

    private fun setupObserver(viewModel: BaseViewModel) {
        this.viewModel = viewModel
        viewModel.loadingHandler.observe(this, Observer {
            if (it){
                dialog.show()
            }else{
                dialog.dismiss()
            }
        })
    }

    override fun onDetach() {
        super.onDetach()
        viewModel.compositeDisposable.clear()
    }
}