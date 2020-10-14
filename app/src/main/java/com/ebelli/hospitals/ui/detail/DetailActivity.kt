package com.ebelli.hospitals.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ebelli.hospitals.R
import com.ebelli.hospitals.data.entities.HospitalEntity
import com.ebelli.hospitals.ui.main.HOSPITAL_EXTRA
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val hospital = intent.getParcelableExtra(HOSPITAL_EXTRA) as HospitalEntity?
        hospital?.apply {
            detail_hospital_name.text = organisationName
            detail_hospital_type.text = organisationType
            detail_hospital_sector.text = sector
            detail_hospital_city.text = city
        }
    }
}