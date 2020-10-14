package com.ebelli.hospitals.data.mappers

import com.ebelli.hospitals.data.entities.HospitalEntity
import com.ebelli.hospitals.domain.models.Hospital

fun Hospital.toAlbumEntity() = HospitalEntity(
    id = id,
    organisationCode = organisationCode,
    organisationType = organisationType,
    sector = sector,
    isPimsManaged = isPimsManaged,
    organisationName = organisationName,
    city = city
)