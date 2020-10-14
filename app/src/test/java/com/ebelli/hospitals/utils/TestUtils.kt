package com.ebelli.hospitals.utils

import com.ebelli.hospitals.domain.models.Hospital

fun get2Hospitals() : List<Hospital> =
     listOf(
        Hospital(
            id = 1421,
            organisationCode = "RV9HE",
            organisationType = "Hospital",
            sector = "NHS Sector",
            isPimsManaged = true,
            organisationName = "East Riding Community Hospital",
            city = "Beverley"),
        Hospital(
            id = 18082,
            organisationCode = "NLL04",
            organisationType = "Hospital",
            sector = "Independent Sector",
            isPimsManaged = true,
            organisationName = "Launceston General Hospital",
            city = "Launceston")

    )
