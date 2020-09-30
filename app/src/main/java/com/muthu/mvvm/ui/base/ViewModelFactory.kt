package com.muthu.mvvm.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.muthu.mvvm.repo.AuthRepo
import com.muthu.mvvm.repo.BaseRepo
import com.muthu.mvvm.ui.auth.AuthViewModel
import java.lang.IllegalArgumentException

class ViewModelFactory(
    private val baseRepo: BaseRepo
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(AuthViewModel::class.java) -> AuthViewModel(repo = baseRepo as AuthRepo) as T

            else -> throw IllegalArgumentException("ViewModelClass Not found")
        }


    }

}