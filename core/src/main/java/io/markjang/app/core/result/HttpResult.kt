package io.markjang.app.core.result


import kotlin.Exception

@Suppress("UNCHECKED_CAST")
sealed class HttpResult<out R> {
    open class Success<out T>(val data: T) : HttpResult<T>()
    data class Error(val exception: Exception) : HttpResult<Nothing>()
    object Loading : HttpResult<Nothing>()

    fun <T> work(callback: (T) -> Unit) {
        when (this) {
            is Success<*> -> {
                callback(data as T)
            }
        }
    }


}