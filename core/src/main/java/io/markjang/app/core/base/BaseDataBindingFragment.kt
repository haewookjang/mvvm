package io.markjang.app.core.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import io.markjang.app.core.delegate.FragmentViewBindingDelegate
import io.markjang.app.core.delegate.viewBinding
import io.markjang.app.core.vm.BaseViewModel

@Suppress("UNCHECKED_CAST")
abstract class BaseDataBindingFragment<VB : ViewDataBinding, VM : BaseViewModel>(@LayoutRes layout: Int) :
    BaseFragment<VM>(layout) {

    val binding: VB by viewBinding {
        createViewDataBinding(it)
    }

    abstract fun createViewDataBinding(view: View): VB

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewDataBinding(binding)
    }

    abstract fun initViewDataBinding(binding: VB)
}