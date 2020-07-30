package io.markjang.app.mvvm.ui.home

import android.view.View
import dagger.hilt.android.AndroidEntryPoint
import io.markjang.app.core.base.BaseDataBindingFragment
import io.markjang.app.core.base.createViewModels
import io.markjang.app.mvvm.R
import io.markjang.app.mvvm.databinding.FragmentHomeBinding


@AndroidEntryPoint
class HomeFragment :
    BaseDataBindingFragment<FragmentHomeBinding, HomeViewModel>(
        R.layout.fragment_home
    ) {

    private val vm: HomeViewModel by createViewModels()

    override fun createViewModel(): HomeViewModel {
        return vm
    }

    override fun createViewDataBinding(view: View) = FragmentHomeBinding.bind(view)
    override fun initViewDataBinding(binding: FragmentHomeBinding) {
        binding.vm = viewModel
    }

}