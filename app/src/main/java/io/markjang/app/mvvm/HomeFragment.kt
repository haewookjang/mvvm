package io.markjang.app.mvvm

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.createViewModelLazy
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import dagger.hilt.EntryPoint
import dagger.hilt.android.AndroidEntryPoint
import io.markjang.app.core.base.BaseDataBindingFragment
import io.markjang.app.core.base.createViewModels
import io.markjang.app.mvvm.databinding.FragmentHomeBinding
import timber.log.Timber


@AndroidEntryPoint
class HomeFragment :
    BaseDataBindingFragment<FragmentHomeBinding, HomeViewModel>(R.layout.fragment_home) {

    private val vm: HomeViewModel by createViewModels()

    override fun createViewModel(): HomeViewModel {
        return vm
    }

    override fun createViewDataBinding(view: View) = FragmentHomeBinding.bind(view)
    override fun initViewDataBinding(binding: FragmentHomeBinding) {
        binding.vm = viewModel
    }

}