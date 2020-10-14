package com.ebelli.hospitals.ui.main

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.ebelli.hospitals.data.entities.HospitalEntity
import com.ebelli.hospitals.domain.repositories.HospitalRepository
import com.ebelli.hospitals.utils.Resource
import com.ebelli.hospitals.utils.getHospitalEntityList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import org.junit.*
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.ArgumentCaptor
import org.mockito.Captor
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner


@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class MainViewModelTest {

    @get:Rule
    val testInstantTaskExecutorRule: TestRule = InstantTaskExecutorRule()
    private val testDispatcher = TestCoroutineDispatcher()

    @Mock
    private lateinit var hospitalRepository: HospitalRepository

    @Mock
    private lateinit var hospitalObserver: Observer<Resource<List<HospitalEntity>>>

    @Captor
    private lateinit var argumentCaptor: ArgumentCaptor<Resource<List<HospitalEntity>>>

    private lateinit var viewModel: MainViewModel


    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)
        viewModel = MainViewModel(hospitalRepository, testDispatcher)
    }

    @After
    fun tearDown(){
        Dispatchers.resetMain()
    }

    @Test
    fun `when getting albums return error`() {
        runBlockingTest {
            Mockito.`when`(hospitalRepository.getHospitals())
                .thenThrow(RuntimeException())

            viewModel.hospitals.observeForever(hospitalObserver)
            viewModel.getHospitals()
        }
        Mockito.verify(hospitalObserver,Mockito.times(2)).onChanged(argumentCaptor.capture())

        val values = argumentCaptor.allValues
        Assert.assertTrue(values[0] is Resource.Loading)
        Assert.assertTrue(values[1] is Resource.Error)
        viewModel.hospitals.removeObserver(hospitalObserver)
    }

    @Test
    fun `when getting albums return empty list throw error`() {
        runBlockingTest {
            Mockito.`when`(hospitalRepository.getHospitals())
                .thenReturn(emptyList())

            viewModel.hospitals.observeForever(hospitalObserver)
            viewModel.getHospitals()
        }
        Mockito.verify(hospitalObserver,Mockito.times(2)).onChanged(argumentCaptor.capture())

        val values = argumentCaptor.allValues
        Assert.assertTrue(values[0] is Resource.Loading)
        Assert.assertTrue(values[1] is Resource.Error)

        viewModel.hospitals.removeObserver(hospitalObserver)
    }

    @Test
    fun `when getting albums return list of albums`() {
        runBlockingTest {
            Mockito.`when`(hospitalRepository.getHospitals())
                .thenReturn(getHospitalEntityList())

            viewModel.hospitals.observeForever(hospitalObserver)
            viewModel.getHospitals()
        }

        Mockito.verify(hospitalObserver,Mockito.times(2)).onChanged(argumentCaptor.capture())

        val values = argumentCaptor.allValues
        Assert.assertTrue(values[0] is Resource.Loading)
        Assert.assertTrue(values[1] is Resource.Success)
        Assert.assertEquals(getHospitalEntityList()[1].organisationName, values[1].data!![1].organisationName)

        viewModel.hospitals.removeObserver(hospitalObserver)
    }
}
