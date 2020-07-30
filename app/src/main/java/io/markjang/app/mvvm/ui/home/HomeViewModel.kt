package io.markjang.app.mvvm.ui.home

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import io.markjang.app.core.result.HttpResult
import io.markjang.app.core.result.error
import io.markjang.app.core.result.success
import io.markjang.app.core.vm.BaseViewModel
import io.markjang.app.mvvm.data.model.Topics
import io.markjang.app.mvvm.data.service.GitHubService
import io.markjang.app.mvvm.domain.GetTopicsUseCase
import io.markjang.app.mvvm.domain.SearchUserUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kr.co.deliveryhero.test.data.model.Users
import timber.log.Timber

class HomeViewModel @ViewModelInject constructor(
    private val searchUserUseCase: SearchUserUseCase,
    private val getTopicsUseCase: GetTopicsUseCase
) :
    BaseViewModel() {

    val test = MutableLiveData(false)

    @ExperimentalCoroutinesApi
    fun search(q: String) {
        viewModelScope.launch {
//            searchUserUseCase(q).collect {
//                it.success<Users> {
//
//                }.error { throwable ->
//                    Timber.e(throwable)
//                }
//            }

            getTopicsUseCase(q).collect {
                it.success<Topics> {
                    it.items.forEach {
                        Timber.d("name :${it.name} ,${it.updatedAt}")
                    }
                }.error {
                    Timber.e(it)
                }
            }

        }
    }
}
