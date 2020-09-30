package com.muthu.mvvm.ui.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.muthu.mvvm.databinding.FragmentLoginBinding
import com.muthu.mvvm.network.AuthApi
import com.muthu.mvvm.repo.AuthRepo
import com.muthu.mvvm.ui.base.BaseFragment

class LoginFragment : BaseFragment<AuthViewModel, FragmentLoginBinding, AuthRepo>() {


    override fun getGetViewModel() = AuthViewModel::class.java

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentLoginBinding.inflate(inflater, container, false)

    override fun getFragmentRepo() = AuthRepo(remoteDataSource.buildApi(AuthApi::class.java))

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


    }
}