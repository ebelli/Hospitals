package com.ebelli.hospitals.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ebelli.hospitals.data.entities.HospitalEntity
import com.ebelli.hospitals.domain.repositories.HospitalRepository
import com.ebelli.hospitals.utils.Resource
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class MainViewModel(private val hospitalRepository: HospitalRepository, private val coroutineContext: CoroutineContext): ViewModel() {

    private val _hospitals = MutableLiveData<Resource<List<HospitalEntity>>>()
    val hospitals: LiveData<Resource<List<HospitalEntity>>> = _hospitals

    fun getHospitals() {
        viewModelScope.launch(coroutineContext) {
            _hospitals.postValue(Resource.Loading())
            try {
                val album = hospitalRepository.getHospitals()
                if (album.isNullOrEmpty()) {
                    _hospitals.postValue(Resource.Error("Cannot retrieve hospitals"))
                } else {
                    _hospitals.postValue(Resource.Success(album))
                }
            } catch (e: Exception) {
                _hospitals.postValue(Resource.Error( e.toString()))
            }
        }
    }
}