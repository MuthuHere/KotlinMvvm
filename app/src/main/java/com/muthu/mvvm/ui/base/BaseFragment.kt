package com.muthu.mvvm.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding
import com.muthu.mvvm.network.RemoteDataSource
import com.muthu.mvvm.repo.BaseRepo

abstract class BaseFragment<VM : ViewModel, B : ViewBinding, R : BaseRepo> : Fragment() {

    protected lateinit var binding: B

    protected val remoteDataSource = RemoteDataSource()



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = getFragmentBinding(inflater, container)

        val factory = ViewModelFactory(getFragmentRepo() )
        return  binding.root
    }

    abstract fun getGetViewModel(): Class<VM>

    abstract fun getFragmentBinding(inflater: LayoutInflater, container: ViewGroup?): B

    abstract fun getFragmentRepo(): R


}
