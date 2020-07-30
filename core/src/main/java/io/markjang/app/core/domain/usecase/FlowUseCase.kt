package io.markjang.app.core.domain.usecase

import io.markjang.app.core.result.Result
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

abstract class FlowUseCase<P, R> constructor(private val dispatcher: CoroutineDispatcher) {

    operator fun invoke(parameters: P): Flow<Result<R>> = execute(parameters)
        .catch { cause ->
            Result.Error(Exception(cause))
        }
        .flowOn(dispatcher)

    protected abstract fun execute(parameters: P): Flow<Result<R>>
}