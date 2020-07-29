package io.markjang.app.core.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.viewbinding.ViewBinding

abstract class BaseDataBindingActivity<VB : ViewDataBinding>(@LayoutRes val layout: Int) :
    BaseActivity() {
    val binding: VB by lazy(LazyThreadSafetyMode.NONE) {
        DataBindingUtil.inflate(layoutInflater, layout, null, false) as VB
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.lifecycleOwner = this

    }
}