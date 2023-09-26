package com.ruangaldo.shared.domain

/**
 * Written with joy and smile by Ruang Aldo on 23/09/23.
 * Github: https://github.com/reinaldoriant
 */

sealed class ViewResource<T> (
    val data: T? = null,
    val errorThrowable: Throwable? = null
) {
    data class Success<T>(
        var root: T
    ) : ViewResource<T>(data = root)

    data class Error<T>(
        var throwable: Throwable?
    ) : ViewResource<T>(errorThrowable = throwable)
}

class InvalidData : Throwable()
class Connectivity : Throwable()
class Authorized : Throwable()
