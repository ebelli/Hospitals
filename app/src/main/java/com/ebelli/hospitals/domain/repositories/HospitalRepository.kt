package com.ebelli.hospitals.domain.repositories

import com.ebelli.hospitals.data.entities.HospitalEntity

interface HospitalRepository {

    suspend fun getHospitals() : List<HospitalEntity>
}