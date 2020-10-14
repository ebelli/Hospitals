package com.ebelli.hospitals.data.remote

import com.ebelli.hospitals.domain.models.Hospital


interface ApiDataStore {

    suspend fun getHospitals(): List<Hospital>

}