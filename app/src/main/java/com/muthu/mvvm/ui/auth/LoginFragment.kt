package com.muthu.mvvm.ui.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import com.muthu.mvvm.databinding.FragmentLoginBinding
import com.muthu.mvvm.network.AuthApi
import com.muthu.mvvm.network.Resource
import com.muthu.mvvm.repo.AuthRepo
import com.muthu.mvvm.ui.base.BaseFragment

class LoginFragment : BaseFragment<AuthViewModel, FragmentLoginBinding, AuthRepo>() {


    override fun getViewModel() = AuthViewModel::class.java

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentLoginBinding.inflate(inflater, container, false)

    override fun getFragmentRepo() = AuthRepo(remoteDataSource.buildApi(AuthApi::class.java))

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        viewModel.loginResponse.observe(viewLifecycleOwner, {
            when (it) {
                is Resource.Success -> {
                    Toast.makeText(requireContext(), "${it.toString()}", Toast.LENGTH_SHORT).show()
                }
                is Resource.Error -> {
                    Toast.makeText(requireContext(), "Login Failed", Toast.LENGTH_SHORT).show()

                }
            }
        })


        binding.apply {
            btnLogin.setOnClickListener {
                val email = etUsername.text.toString().trim()
                val password = etPassword.text.toString().trim()

                viewModel.userLogin(email, password)

            }
        }


    }
}