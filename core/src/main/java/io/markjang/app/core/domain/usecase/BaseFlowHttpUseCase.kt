package io.markjang.app.core.domain.usecase

import io.markjang.app.core.result.HttpResult
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.retryWhen

abstract class BaseFlowHttpUseCase<P, R> constructor(private val dispatcher: CoroutineDispatcher) {

    companion object {
        const val RETRY_COUNT = 2
    }

    @ExperimentalCoroutinesApi
    operator fun invoke(parameters: P) = flow<HttpResult<R>> {
        emit(
            HttpResult.Success(execute(parameters))
        )
    }.retryWhen { cause, attempt ->
        delay(2 * 1000L)
        attempt < RETRY_COUNT
    }.catch { cause ->
        emit(HttpResult.Error(Exception(cause)))
    }.flowOn(dispatcher)

    @Throws(RuntimeException::class)
    abstract suspend fun execute(parameters: P): R
}