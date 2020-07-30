package io.markjang.app.core.domain.usecase

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.markjang.app.core.result.Result
import kotlinx.coroutines.CoroutineDispatcher


abstract class BaseLiveDataUseCase<T, R> constructor(dispatcher: CoroutineDispatcher) :
    BaseUseCase<T, R>(dispatcher) {
    private val _livedata = MutableLiveData<R>()
    val liveData: LiveData<R>
        get() = _livedata

    suspend fun invoke(parameter: T, liveData: MutableLiveData<R> = _livedata): Result<R> {
        val result = invoke(parameter)
        if (result is Result.Success) {
            _livedata.postValue(result.data)
        }
        return result
    }

}