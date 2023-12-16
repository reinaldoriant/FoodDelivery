package com.ruangaldo.remote

import app.cash.turbine.test
import com.ruangaldo.remote.model.LoginRemoteResponse
import com.ruangaldo.remote.repository.LoginRemoteRepository
import com.ruangaldo.remote.service.LoginRemoteService
import com.ruangaldo.shared.data.AuthorizedException
import com.ruangaldo.shared.data.ConnectivityException
import com.ruangaldo.shared.data.DataResource
import com.ruangaldo.shared.data.InvalidDataException
import io.mockk.clearAllMocks
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.confirmVerified
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.runBlocking
import okhttp3.ResponseBody.Companion.toResponseBody
import okio.IOException
import org.junit.After
import org.junit.Before
import org.junit.Test
import retrofit2.HttpException
import retrofit2.Response

class LoginRemoteRepositoryTest {
    private val service = mockk<LoginRemoteService>()
    private lateinit var repository: LoginRemoteRepository

    @Before
    fun setUp() {
        repository = LoginRemoteRepository(service = service)
    }

    @Test
    fun testLoginRemoteRepositoryConnectivityError() = runBlocking {
        expect(
            repository = repository,
            expectedResult = ConnectivityException()
        )
    }

    @Test
    fun testLoginRemoteRepositoryOn500HttpResponse() {
        expect(
            withStatusCode = 500,
            repository = repository,
            expectedResult = AuthorizedException()
        )
    }

    @Test
    fun testLoginRemoteRepositoryInvalidError() {
        expect(
            repository = repository,
            expectedResult = InvalidDataException()
        )
    }

    @Test
    fun testLoginRemoteRepositoryOn200HttpResponse() {
        expect(
            repository = repository,
            receivedResult = loginRemoteResponseDummy,
            expectedResult = DataResource.Success(
                loginRemoteResponseDummy
            )
        )
    }

    @After
    fun tearDown() {
        clearAllMocks()
    }

    private fun expect(
        withStatusCode: Int? = null,
        repository: LoginRemoteRepository,
        receivedResult: Any? = null,
        expectedResult: Any
    ) = runBlocking {
        when {
            expectedResult is ConnectivityException -> {
                coEvery {
                    service.post(loginRemoteRequestDummy)
                } throws IOException()
            }
            withStatusCode != null -> {
                val response = Response.error<LoginRemoteResponse>(
                    withStatusCode,
                    "".toResponseBody(null)
                )
                coEvery {
                    service.post(loginRemoteRequestDummy)
                } throws HttpException(response)
            }

            expectedResult is DataResource.Success<*> -> {
                coEvery {
                    service.post(loginRemoteRequestDummy)
                } returns receivedResult as LoginRemoteResponse
            }

            else -> {
                coEvery {
                    service.post(loginRemoteRequestDummy)
                } throws Exception()
            }
        }

        repository.post(loginRemoteRequestDummy).test {
            when (val result = awaitItem()) {
                is DataResource.Success -> {
                    assertEquals(
                        expectedResult,
                        result
                    )
                }
                is DataResource.Error -> {
                    assertEquals(
                        expectedResult::class.java,
                        result.throwable?.let {
                            it::class.java
                        }
                    )
                }
            }
            awaitComplete()
        }

        coVerify(exactly = 1) {
            service.post(loginRemoteRequestDummy)
        }

        confirmVerified(service)
    }
}
