package io.markjang.app.mvvm

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import io.markjang.app.core.result.HttpResult
import io.markjang.app.core.vm.BaseViewModel
import io.markjang.app.mvvm.data.service.GitHubService
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import timber.log.Timber

class HomeViewModel @ViewModelInject constructor(private val gitHubService: GitHubService) :
    BaseViewModel() {

    val test = MutableLiveData(false)
    fun search(q: String) {
        viewModelScope.launch {
            request {
                gitHubService.searchUsers(q)
            }.collect {
                when (it) {
                    is HttpResult.Success -> {
                        it.data.items.forEach { user ->
                            Timber.d(user.login)
                        }
                    }
                }
            }
        }
    }
}