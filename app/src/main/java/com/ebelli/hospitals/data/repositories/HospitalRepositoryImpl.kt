package com.ebelli.hospitals.data.repositories

import com.ebelli.hospitals.data.mappers.toAlbumEntity
import com.ebelli.hospitals.data.remote.ApiDataStore
import com.ebelli.hospitals.domain.repositories.HospitalRepository


class HospitalRepositoryImpl(private val apiDataStore: ApiDataStore): HospitalRepository {

    override suspend fun getHospitals() = apiDataStore.getHospitals().map { it.toAlbumEntity() }

}