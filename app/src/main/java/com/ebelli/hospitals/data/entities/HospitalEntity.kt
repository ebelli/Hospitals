package com.ebelli.hospitals.data.entities

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class HospitalEntity(
    val id: Int,
    val organisationCode: String,
    val organisationType: String,
    val sector: String,
    val isPimsManaged: Boolean,
    val organisationName: String,
    val city: String
) : Parcelable