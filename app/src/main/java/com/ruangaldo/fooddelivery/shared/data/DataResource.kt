package com.ruangaldo.fooddelivery.shared.data

import com.ruangaldo.fooddelivery.shared.Constant.Companion.INT_EMPTY

/**
 * Written with joy and smile by Ruang Aldo on 23/09/23.
 * Github: https://github.com/reinaldoriant
 */

sealed class DataResource<T> (
    val data: T? = null,
    val errorCode: Int? = null,
    val errorThrowable: Throwable? = null,
) {
    data class Success<T>(
        var root: T,
    ) : DataResource<T>(data = root)

    data class Error<T>(
        var code: Int? = INT_EMPTY,
        var throwable: Throwable?,
    ) : DataResource<T>(errorCode = code, errorThrowable = throwable)
}

class InvalidDataException : Throwable()
class ConnectivityException : Throwable()
