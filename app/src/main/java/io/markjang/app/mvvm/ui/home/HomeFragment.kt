package io.markjang.app.mvvm.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import dagger.hilt.android.AndroidEntryPoint
import io.markjang.app.core.base.BaseDataBindingFragment
import io.markjang.app.core.base.createViewModels
import io.markjang.app.mvvm.R
import io.markjang.app.mvvm.databinding.FragmentHomeBinding
import io.markjang.app.mvvm.service.DemoService


@AndroidEntryPoint
class HomeFragment :
    BaseDataBindingFragment<FragmentHomeBinding, HomeViewModel>(
        R.layout.fragment_home
    ) {

    private val vm: HomeViewModel by createViewModels()

    override fun createViewModel(): HomeViewModel {
        return vm
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.search.observe(this, Observer {
            Intent(requireContext(), DemoService::class.java).also {
                activity?.startService(it)
            }
        })
    }

    override fun createViewDataBinding(view: View) = FragmentHomeBinding.bind(view)
    override fun initViewDataBinding(binding: FragmentHomeBinding) {
        binding.vm = viewModel
    }

}