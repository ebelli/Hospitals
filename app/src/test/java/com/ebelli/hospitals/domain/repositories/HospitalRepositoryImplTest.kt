package com.ebelli.hospitals.domain.repositories

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.ebelli.hospitals.data.remote.ApiDataStore
import com.ebelli.hospitals.data.repositories.HospitalRepositoryImpl
import com.ebelli.hospitals.utils.get2Hospitals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class HospitalRepositoryImplTest {

    @get:Rule
    val testInstantTaskExecutorRule: TestRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var apiDataStore: ApiDataStore

    private lateinit var hospitalRepository: HospitalRepository


    @Before
    fun setUp() {
        hospitalRepository = HospitalRepositoryImpl(apiDataStore)
    }


    @Test
    fun `get list of hospitals when calling endpoint`() {
        val hospitals = get2Hospitals()
        runBlockingTest {
            Mockito.`when`(apiDataStore.getHospitals())
                .thenReturn(hospitals)

            val result = hospitalRepository.getHospitals()
            Assert.assertEquals(result.size , 2)
            Assert.assertEquals(result[0].id , 1421)
            Assert.assertEquals(result[1].id , 18082)
            Assert.assertEquals(result[1].organisationName , "Launceston General Hospital")
            Assert.assertEquals(result[1].city , "Launceston")
        }
    }
}