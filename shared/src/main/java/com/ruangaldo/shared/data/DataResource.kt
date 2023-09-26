package com.ruangaldo.shared.data

/**
 * Written with joy and smile by Ruang Aldo on 23/09/23.
 * Github: https://github.com/reinaldoriant
 */

sealed class DataResource<T> (
    val data: T? = null,
    val errorCode: Int? = null,
    val errorThrowable: Throwable? = null
) {
    data class Success<T>(
        var root: T
    ) : DataResource<T>(data = root)

    data class Error<T>(
        var throwable: Throwable?
    ) : DataResource<T>(errorThrowable = throwable)
}

class InvalidDataException : Throwable()
class AuthorizedException : Throwable()
class ConnectivityException : Throwable()
