package com.ruangaldo.remote

import app.cash.turbine.test
import com.ruangaldo.remote.model.LoginRemoteResponse
import com.ruangaldo.remote.repository.ILoginRemoteRepository
import com.ruangaldo.remote.usecase.LoginRemoteUseCase
import com.ruangaldo.shared.data.AuthorizedException
import com.ruangaldo.shared.data.ConnectivityException
import com.ruangaldo.shared.data.DataResource
import com.ruangaldo.shared.data.InvalidDataException
import com.ruangaldo.shared.domain.Authorized
import com.ruangaldo.shared.domain.Connectivity
import com.ruangaldo.shared.domain.InvalidData
import com.ruangaldo.shared.domain.ViewResource
import io.mockk.MockKAnnotations
import io.mockk.clearAllMocks
import io.mockk.confirmVerified
import io.mockk.every
import io.mockk.spyk
import io.mockk.verify
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test

class LoginRemoteUseCaseTest {
    private val repository = spyk<ILoginRemoteRepository>()
    private lateinit var useCase: LoginRemoteUseCase

    @Before
    fun setUp() {
        MockKAnnotations.init(this, relaxed = true)
        useCase = LoginRemoteUseCase(repository)
    }

    @Test
    fun testInitDoesNotRequestData() {
        verify(exactly = 0) {
            repository.post(loginRemoteRequestDummy)
        }

        confirmVerified(repository)
    }

    @Test
    fun testLoginRemote() = runBlocking {
        every {
            repository.post(loginRemoteRequestDummy)
        } returns flowOf()

        useCase.post(loginRequestEntityDummy).test {
            awaitComplete()
        }

        verify(exactly = 1) {
            repository.post(loginRemoteRequestDummy)
        }

        confirmVerified(repository)
    }

    @Test
    fun testLoginRemoteTwice() = runBlocking {
        every {
            repository.post(loginRemoteRequestDummy)
        } returns flowOf()

        useCase.post(loginRequestEntityDummy).test {
            awaitComplete()
        }

        useCase.post(loginRequestEntityDummy).test {
            awaitComplete()
        }

        verify(exactly = 2) {
            repository.post(loginRemoteRequestDummy)
        }

        confirmVerified(repository)
    }

    @Test
    fun testLoginRemoteConnectivityError() {
        expect(
            useCase = useCase,
            actualResult = DataResource.Error(ConnectivityException()),
            expectedResult = Connectivity(),
            exactly = 1
        )
    }

    @Test
    fun testLoginRemoteInvalidDataError() {
        expect(
            useCase = useCase,
            actualResult = DataResource.Error(InvalidDataException()),
            expectedResult = InvalidData(),
            exactly = 1
        )
    }

    @Test
    fun testLoginRemoteAuthorizedRequestError() {
        expect(
            useCase = useCase,
            actualResult = DataResource.Error(AuthorizedException()),
            expectedResult = Authorized(),
            exactly = 1
        )
    }

    @Test
    fun testLoginRemoteOn200() {
        expect(
            useCase = useCase,
            actualResult = DataResource.Success(loginRemoteResponseDummy),
            expectedResult = ViewResource.Success(
                loginEntityDummy
            ),
            exactly = 1
        )
    }

    @After
    fun tearDown() {
        clearAllMocks()
    }

    private fun expect(
        useCase: LoginRemoteUseCase,
        actualResult: DataResource<LoginRemoteResponse>,
        expectedResult: Any,
        exactly: Int = -1
    ) = runBlocking {
        every {
            repository.post(loginRemoteRequestDummy)
        } returns flowOf(actualResult)

        useCase.post(loginRequestEntityDummy).test {
            when (val receivedResult = awaitItem()) {
                is ViewResource.Success -> {
                    assertEquals(
                        expectedResult,
                        receivedResult
                    )
                }

                is ViewResource.Error -> {
                    assertEquals(
                        expectedResult::class.java,
                        receivedResult.throwable?.let {
                            it::class.java
                        }
                    )
                }
            }
            awaitComplete()
        }

        verify(exactly = exactly) {
            repository.post(loginRemoteRequestDummy)
        }

        confirmVerified(repository)
    }
}
