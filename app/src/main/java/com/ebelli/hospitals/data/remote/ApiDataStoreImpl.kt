package com.ebelli.hospitals.data.remote

import com.ebelli.hospitals.data.remote.ApiDataStore
import com.ebelli.hospitals.data.remote.ApiService

class ApiDataStoreImpl(private val apiService: ApiService): ApiDataStore {

    override suspend fun getHospitals() = apiService.getHospitals()
}