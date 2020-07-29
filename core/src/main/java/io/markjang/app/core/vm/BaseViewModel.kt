package io.markjang.app.core.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.markjang.app.core.result.HttpResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.withContext

abstract class BaseViewModel : ViewModel() {

    private val _loading = MutableLiveData(false)
    val loading: LiveData<Boolean>
        get() = _loading

    override fun onCleared() {
        super.onCleared()
    }


    @ExperimentalCoroutinesApi
    suspend fun <T> request(req: suspend () -> T): Flow<HttpResult<T>> =
        withContext(Dispatchers.IO) {
            flow {
                val result = req.invoke()
                emit(HttpResult.Success(result))
            }.onStart {
                _loading.postValue(true)
            }.onCompletion {
                _loading.postValue(false)
            }.retryWhen { cause, attempt ->
                delay(2 * 1000L)
                attempt < 2
            }
        }

}