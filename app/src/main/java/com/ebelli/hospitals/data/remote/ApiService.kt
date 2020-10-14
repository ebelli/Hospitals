package com.ebelli.hospitals.data.remote

import com.ebelli.hospitals.domain.models.Hospital
import retrofit2.http.GET

interface ApiService {

    @GET("hospitals.json")
    suspend fun getHospitals(): List<Hospital>
}