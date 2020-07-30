package io.markjang.app.core.domain.usecase

import io.markjang.app.core.result.Result
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

abstract class BaseUseCase<T, R> constructor(private val dispatcher: CoroutineDispatcher) {
    @Throws(RuntimeException::class)
    abstract suspend fun execute(parameter: T): R

    suspend fun invoke(parameter: T): Result<R> {
        return try {
            withContext(dispatcher) {
                execute(parameter).let {
                    Result.Success(it)
                }
            }
        } catch (t: Throwable) {
            Result.Error(Exception(t))
        }
    }
}

