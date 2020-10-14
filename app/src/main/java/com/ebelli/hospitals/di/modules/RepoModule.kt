package com.ebelli.hospitals.di.modules

import com.ebelli.hospitals.data.repositories.HospitalRepositoryImpl
import com.ebelli.hospitals.domain.repositories.HospitalRepository
import org.koin.dsl.module

val repoModule = module {
    single <HospitalRepository> { return@single HospitalRepositoryImpl(get()) }
}