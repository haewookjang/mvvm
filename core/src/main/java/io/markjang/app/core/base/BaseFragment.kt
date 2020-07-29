package io.markjang.app.core.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.annotation.MainThread
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import io.markjang.app.core.vm.BaseViewModel

abstract class BaseFragment<VM : BaseViewModel>(@LayoutRes layout: Int) : Fragment(layout) {
    lateinit var viewModel: VM
    abstract fun createViewModel(): VM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = createViewModel()

    }
}

@MainThread
inline fun <reified VM : BaseViewModel> Fragment.createViewModels() =
    viewModels<VM>()
