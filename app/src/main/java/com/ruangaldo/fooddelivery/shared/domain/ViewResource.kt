package com.ruangaldo.fooddelivery.shared.domain

/**
 * Written with joy and smile by Ruang Aldo on 23/09/23.
 * Github: https://github.com/reinaldoriant
 */

// terlalu banyak plan kedepannya. Ini tidak perlu, masuk ke extreme programming -> solusi
// harusnya dibuat shared itu setelah banyak yang memakai. Kalau di konsep TDD fokus dengan satu hal current condition
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
