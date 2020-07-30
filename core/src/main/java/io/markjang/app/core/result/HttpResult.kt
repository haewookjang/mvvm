package io.markjang.app.core.result


import kotlin.Exception

@Suppress("UNCHECKED_CAST")
sealed class HttpResult<out R> {
    open class Success<out T>(val data: T) : HttpResult<T>()
    data class Error(val exception: Exception) : HttpResult<Nothing>()
    object Loading : HttpResult<Nothing>()
}

inline fun <R> HttpResult<*>.success(callback: (R) -> Unit): HttpResult<*> {
    when (this) {
        is HttpResult.Success -> {
            callback(data as R)
        }
    }
    return this
}

inline fun HttpResult<*>.error(callback: (Throwable) -> Unit): HttpResult<*> {
    when (this) {
        is HttpResult.Error -> {
            callback(this.exception)
        }
    }
    return this
}